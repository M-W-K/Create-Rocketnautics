package dev.devce.rocketnautics.network;

import dev.devce.rocketnautics.RocketNautics;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record JetpackPayload(int entityId, boolean active) implements CustomPacketPayload {
    public static final Type<JetpackPayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(RocketNautics.MODID, "jetpack_state"));

    public static final StreamCodec<FriendlyByteBuf, JetpackPayload> CODEC = StreamCodec.composite(
            ByteBufCodecs.VAR_INT,
            JetpackPayload::entityId,
            ByteBufCodecs.BOOL,
            JetpackPayload::active,
            JetpackPayload::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
