package net.darkhax.leveltextfix.common.mixin;

import net.darkhax.leveltextfix.common.impl.LevelTextFixMod;
import net.minecraft.client.resources.language.ClientLanguage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientLanguage.class)
public class MixinClientLanguage {

    @Inject(method = "getOrDefault", at = @At("HEAD"), cancellable = true)
    public void getOrDefault(String key, String fallback, CallbackInfoReturnable<String> cbi) {
        if (LevelTextFixMod.config != null && LevelTextFixMod.config.replace_roman_numerals) {
            if (key.startsWith("enchantment.level.") && LevelTextFixMod.isNumeric(key.substring(18))) {
                cbi.setReturnValue(key.substring(18));
            }
            else if (key.startsWith("potion.potency.") && LevelTextFixMod.isNumeric(key.substring(15))) {
                cbi.setReturnValue(Integer.toString(Integer.parseInt(key.substring(15)) + 1));
            }
        }
    }

    @Inject(method = "has", at = @At("HEAD"), cancellable = true)
    public void has(String key, CallbackInfoReturnable<Boolean> cbi) {
        if (LevelTextFixMod.config != null && LevelTextFixMod.config.replace_roman_numerals) {
            if (key.startsWith("enchantment.level.") && LevelTextFixMod.isNumeric(key.substring(18))) {
                cbi.setReturnValue(true);
            }
            else if (key.startsWith("potion.potency.") && LevelTextFixMod.isNumeric(key.substring(15))) {
                cbi.setReturnValue(true);
            }
        }
    }
}