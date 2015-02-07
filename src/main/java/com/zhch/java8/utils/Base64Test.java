package com.zhch.java8.utils;

import java.io.IOException;
import java.util.Base64;

public class Base64Test {

}

class Java8Impl implements Base64Codec, Base64ByteCodec
{
    private final Base64.Decoder m_decoder = Base64.getDecoder();
    private final Base64.Encoder m_encoder = Base64.getEncoder();
    @Override
    public String encode(byte[] data) {
        return m_encoder.encodeToString(data);
    }
    @Override
    public byte[] decode(String base64) throws IOException {
        return m_decoder.decode(base64);
    }
    public byte[] encodeBytes(byte[] data) {
        return m_encoder.encode( data );
    }
    public byte[] decodeBytes(byte[] base64) throws IOException {
        return m_decoder.decode( base64 );
    }
}
