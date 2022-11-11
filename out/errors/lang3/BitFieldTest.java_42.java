@Test
public void testByte12585() { 
         assertEquals(0, new BitField(0).setByteBoolean((byte) 0, true)); 
         assertEquals(1, new BitField(1).setByteBoolean((byte) 0, true)); 
         assertEquals(2, new BitField(2).setByteBoolean((byte) 0, true)); 
         assertEquals(4, new BitField(4).setByteBoolean((byte) 0, true)); 
         assertEquals(8, new BitField(8).setByteBoolean((byte) 0, true)); 
         assertEquals(16, new BitField(16).setByteBoolean((byte) 0, true)); 
         assertEquals(32, new BitField(32).setByteBoolean((byte) 0, true)); 
         assertEquals(64, new BitField(64).setByteBoolean((byte) 0, true)); 
         assertEquals(-128, new BitField(128).setByteBoolean((byte) 0, true)); 
         assertEquals(1, new BitField(0).setByteBoolean((byte) 1, false)); 
         assertEquals(0, new BitField(1).setByteBoolean((byte) 1, false)); 
         assertEquals(0, new BitField(2).setByteBoolean((byte) 2, false)); 
         assertEquals(0, new BitField(4).setByteBoolean((byte) 4, false)); 
         assertEquals(0, new BitField(8).setByteBoolean((byte) 8, false)); 
         assertEquals(0, new BitField(16).setByteBoolean((byte) 16, false)); 
         assertEquals(0, new BitField(32).setByteBoolean((byte) 32, false)); 
         assertEquals(0, new BitField(64).setByteBoolean((byte) 64, false)); 
         assertEquals(0, new BitField(128).setByteBoolean((byte) 128, false)); 
         assertEquals(-2, new BitField(1).setByteBoolean((byte) 255, false)); 
         final byte clearedBit = new Bit