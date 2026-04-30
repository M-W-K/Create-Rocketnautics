package dev.devce.rocketnautics.network;

import dev.devce.rocketnautics.RocketNautics;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record JetpackTogglePayload() implements CustomPacketPayload {
    public static final Type<JetpackTogglePayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(RocketNautics.MODID, "jetpack_toggle"));

    public static final StreamCodec<FriendlyByteBuf, JetpackTogglePayload> CODEC = StreamCodec.unit(new JetpackTogglePayload());

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
