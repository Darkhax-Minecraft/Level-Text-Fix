package net.darkhax.leveltextfix.mixin;

import net.darkhax.leveltextfix.LevelTextFixCommon;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Component.class)
public interface MixinComponent {

    @Inject(method = "translatable(Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;", at=@At("HEAD"), cancellable = true)
    private static void translatable(String key, CallbackInfoReturnable<MutableComponent> cbi) {

        if (LevelTextFixCommon.config != null && LevelTextFixCommon.config.replaceRomanNumerals) {

            if (key.startsWith("enchantment.level.")) {

                final String enchantmentLevel = key.substring(18);

                if (LevelTextFixCommon.isNumeric(enchantmentLevel)) {

                    cbi.setReturnValue(Component.literal(enchantmentLevel));
                }
            }

            else if (key.startsWith("potion.potency.")) {

                final String potencyLevel = key.substring(15);

                if (LevelTextFixCommon.isNumeric(potencyLevel)) {

                    cbi.setReturnValue(Component.literal(Integer.toString(Integer.parseInt(potencyLevel) + 1)));
                }
            }
        }
    }
}
