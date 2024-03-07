package net.darkhax.leveltextfix.mixin;

import net.darkhax.leveltextfix.LevelTextFixCommon;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.world.item.alchemy.PotionUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(PotionUtils.class)
public class MixinPotionUtils {

    @ModifyArg(method = "addPotionTooltip(Ljava/util/List;Ljava/util/List;FF)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/network/chat/Component;translatable(Ljava/lang/String;[Ljava/lang/Object;)Lnet/minecraft/network/chat/MutableComponent;"), index = 1)
    private static Object[] replaceLevelComponent(Object[] args) {

        if (LevelTextFixCommon.config != null && LevelTextFixCommon.config.replaceRomanNumerals && args.length == 2 && args[1] instanceof Component component && component.getContents() instanceof TranslatableContents translatable) {

            final String potencyLevel = translatable.getKey().substring(15);

            if (LevelTextFixCommon.isNumeric(potencyLevel)) {

                args[1] = Component.literal(Integer.toString(Integer.parseInt(potencyLevel) + 1));
            }
        }

        return args;
    }
}
