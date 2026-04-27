package dev.devce.rocketnautics.network;

import dev.devce.rocketnautics.RocketNautics;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

import java.util.UUID;

public record ReentryHeatPayload(double x, double y, double z, float intensity) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<ReentryHeatPayload> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(RocketNautics.MODID, "reentry_heat"));
    
    public static final StreamCodec<RegistryFriendlyByteBuf, ReentryHeatPayload> CODEC = StreamCodec.composite(
        ByteBufCodecs.DOUBLE, ReentryHeatPayload::x,
        ByteBufCodecs.DOUBLE, ReentryHeatPayload::y,
        ByteBufCodecs.DOUBLE, ReentryHeatPayload::z,
        ByteBufCodecs.FLOAT, ReentryHeatPayload::intensity,
        ReentryHeatPayload::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
