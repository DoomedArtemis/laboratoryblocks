package de.artemis.laboratoryblocks.common.items;

import de.artemis.laboratoryblocks.common.registration.ModDataComponents;
import io.netty.buffer.ByteBuf;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import java.util.List;

import com.mojang.serialization.Codec;

public class ConfigurationToolItem extends Item {
    public ConfigurationToolItem(Properties properties) {
        super(properties);
    }

    public State getState(ItemStack stack) {
        return stack.getOrDefault(ModDataComponents.CONFIGURATION_TOOL_STATE, State.REMOVE_GLOWSTONE);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack usedStack = player.getItemInHand(usedHand);

        if (player.isCrouching()) {
            usedStack.set(ModDataComponents.CONFIGURATION_TOOL_STATE, getState(usedStack).next());
            return InteractionResultHolder.success(usedStack);
        }

        return InteractionResultHolder.pass(usedStack);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, @NotNull TooltipContext context, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        tooltip.add(Component.translatable("tooltip.laboratoryblocks.configuration_tool_1", Component.translatable("tooltip.laboratoryblocks.configuration_tool.state." + getState(itemStack).serializedName).withStyle(Style.EMPTY.withColor(0x549CFC))).withStyle(ChatFormatting.GRAY));
        tooltip.add(Component.translatable("tooltip.laboratoryblocks.configuration_tool_2").withStyle(ChatFormatting.GRAY));

        super.appendHoverText(itemStack, context, tooltip, flag);
    }

    public static enum State implements StringRepresentable {

        REMOVE_GLOWSTONE("remove_glowstone"),
        REMOVE_REDSTONE("remove_redstone"),
        REVERSE_REDSTONE_CONTROL("reverse_redstone_control");

        public static final Codec<State> CODEC = StringRepresentable.fromValues(State::values);
        public static final StreamCodec<ByteBuf, State> STREAM_CODEC = ByteBufCodecs.VAR_INT.map(id -> State.values()[id], State::ordinal);

        private final String serializedName;

        private State(String serializedName) {
            this.serializedName = serializedName;
        }

        public State next() {
            return switch (this) {
                case REMOVE_GLOWSTONE -> REMOVE_REDSTONE;
                case REMOVE_REDSTONE -> REVERSE_REDSTONE_CONTROL;
                case REVERSE_REDSTONE_CONTROL -> REMOVE_GLOWSTONE;
            };
        }

        @Override
        public String getSerializedName() {
            return serializedName;
        }
    }
}
