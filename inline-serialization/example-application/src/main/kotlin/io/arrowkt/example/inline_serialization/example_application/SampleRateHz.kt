package io.arrowkt.example.inline_serialization.example_application

import kotlinx.serialization.*
import kotlinx.serialization.internal.*

@Serializable(with = SampleRateHzSerializer::class)
data class SampleRateHz(val value : Int) {
    override fun toString(): String = "$value hz"
}

@Serializer(forClass = SampleRateHz::class)
class SampleRateHzSerializer : KSerializer<SampleRateHz> {
    override val descriptor: SerialDescriptor =
        IntDescriptor.withName(SampleRateHz::class.java.simpleName)
        //PrimitiveDescriptor(SampleRateHz::class.java.simpleName, PrimitiveKind.INT)

    //override fun serialize(encoder: Encoder, value: SampleRateHz) {
    //    encoder.encodeInt(value.value)
    override fun serialize(encoder: Encoder, obj: SampleRateHz) {
        encoder.encodeInt(obj.value)
    }

    override fun deserialize(decoder: Decoder): SampleRateHz {
        return SampleRateHz(decoder.decodeInt())
    }
}
