package net.darkhax.leveltextfix.mixin;

import net.darkhax.leveltextfix.LevelTextFixCommon;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.world.item.enchantment.Enchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(Enchantment.class)
public class MixinEnchantment {

    @ModifyArg(method = "getFullname(I)Lnet/minecraft/network/chat/Component;", at = @At(value = "INVOKE", target = "Lnet/minecraft/network/chat/MutableComponent;append(Lnet/minecraft/network/chat/Component;)Lnet/minecraft/network/chat/MutableComponent;"), index = 0)
    private Component replaceLevelComponent(Component original) {

        if (LevelTextFixCommon.config != null && LevelTextFixCommon.config.replaceRomanNumerals && original.getContents() instanceof TranslatableContents translatable && translatable.getKey().startsWith("enchantment.level.")) {

            final String enchantmentLevel = translatable.getKey().substring(18);

            if (LevelTextFixCommon.isNumeric(enchantmentLevel)) {

                return Component.literal(enchantmentLevel);
            }
        }

        return original;
    }
}
