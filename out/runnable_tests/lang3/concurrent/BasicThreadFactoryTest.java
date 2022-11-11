@Test 
 public void testNewThreadExHandler309() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testNewThreadExHandler321() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testNewThreadExHandler509() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testNewThreadExHandler563() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testNewThreadExHandler632() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testNewThreadExHandler831() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testNewThreadExHandler894() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testNewThreadNamingPattern1154() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final int count = 12; 
     for (int i = 0; i < count; i++) { 
         EasyMock.expect(wrapped.newThread(r)).andReturn(new Thread()); 
     } 
     EasyMock.replay(wrapped, r); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).namingPattern(PATTERN).build(); 
     for (int i = 0; i < count; i++) { 
         final Thread t = factory.newThread(r); 
         assertEquals("Wrong thread name", String.format(PATTERN, Long.valueOf(i + 1)), t.getName()); 
         assertEquals("Wrong thread count", i + 1, factory.getThreadCount()); 
     } 
     EasyMock.verify(wrapped, r); 
 } 
@Test 
 public void testBuilderReset1489() { 
     final ThreadFactory wrappedFactory = EasyMock.createMock(ThreadFactory.class); 
     final Thread.UncaughtExceptionHandler exHandler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     EasyMock.replay(wrappedFactory, exHandler); 
     builder.namingPattern(PATTERN).daemon(true).priority(Thread.MAX_PRIORITY).uncaughtExceptionHandler(exHandler).wrappedFactory(wrappedFactory); 
     builder.reset(); 
     final BasicThreadFactory factory = builder.build(); 
     checkFactoryDefaults(factory); 
     assertNotSame("Wrapped factory not reset", wrappedFactory, factory.getWrappedFactory()); 
     EasyMock.verify(wrappedFactory, exHandler); 
 } 
@Test 
 public void testNewThreadExHandler1500() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testNewThreadExHandler1513() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testNewThreadExHandler1517() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testNewThreadExHandler1651() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testNewThreadExHandler1684() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testNewThreadExHandler1811() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testNewThreadExHandler2124() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testNewThreadExHandler2459() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testNewThreadPriority2471() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r); 
     final int priority = Thread.NORM_PRIORITY + 1; 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).priority(priority).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong priority", priority, t.getPriority()); 
     EasyMock.verify(wrapped, r); 
 } 
@Test 
 public void testNewThreadExHandler2548() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testBuilderReset2637() { 
     final ThreadFactory wrappedFactory = EasyMock.createMock(ThreadFactory.class); 
     final Thread.UncaughtExceptionHandler exHandler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     EasyMock.replay(wrappedFactory, exHandler); 
     builder.namingPattern(PATTERN).daemon(true).priority(Thread.MAX_PRIORITY).uncaughtExceptionHandler(exHandler).wrappedFactory(wrappedFactory); 
     builder.reset(); 
     final BasicThreadFactory factory = builder.build(); 
     checkFactoryDefaults(factory); 
     assertNotSame("Wrapped factory not reset", wrappedFactory, factory.getWrappedFactory()); 
     EasyMock.verify(wrappedFactory, exHandler); 
 } 
@Test 
 public void testNewThreadExHandler3173() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testNewThreadExHandler3511() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test(expected = NullPointerException.class) 
 public void testBuildUncaughtExceptionHandlerNull3540() { 
     builder.uncaughtExceptionHandler(null); 
 } 
@Test 
 public void testNewThreadDaemonFalse3592() { 
     checkDaemonFlag(false); 
 } 
@Test 
 public void testNewThreadExHandler3649() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testNewThreadNamingPattern3688() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final int count = 12; 
     for (int i = 0; i < count; i++) { 
         EasyMock.expect(wrapped.newThread(r)).andReturn(new Thread()); 
     } 
     EasyMock.replay(wrapped, r); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).namingPattern(PATTERN).build(); 
     for (int i = 0; i < count; i++) { 
         final Thread t = factory.newThread(r); 
         assertEquals("Wrong thread name", String.format(PATTERN, Long.valueOf(i + 1)), t.getName()); 
         assertEquals("Wrong thread count", i + 1, factory.getThreadCount()); 
     } 
     EasyMock.verify(wrapped, r); 
 } 
@Test 
 public void testNewThreadExHandler4134() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testBuilderReset4260() { 
     final ThreadFactory wrappedFactory = EasyMock.createMock(ThreadFactory.class); 
     final Thread.UncaughtExceptionHandler exHandler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     EasyMock.replay(wrappedFactory, exHandler); 
     builder.namingPattern(PATTERN).daemon(true).priority(Thread.MAX_PRIORITY).uncaughtExceptionHandler(exHandler).wrappedFactory(wrappedFactory); 
     builder.reset(); 
     final BasicThreadFactory factory = builder.build(); 
     checkFactoryDefaults(factory); 
     assertNotSame("Wrapped factory not reset", wrappedFactory, factory.getWrappedFactory()); 
     EasyMock.verify(wrappedFactory, exHandler); 
 } 
@Test 
 public void testNewThreadExHandler4576() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testNewThreadNamingPattern4589() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final int count = 12; 
     for (int i = 0; i < count; i++) { 
         EasyMock.expect(wrapped.newThread(r)).andReturn(new Thread()); 
     } 
     EasyMock.replay(wrapped, r); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).namingPattern(PATTERN).build(); 
     for (int i = 0; i < count; i++) { 
         final Thread t = factory.newThread(r); 
         assertEquals("Wrong thread name", String.format(PATTERN, Long.valueOf(i + 1)), t.getName()); 
         assertEquals("Wrong thread count", i + 1, factory.getThreadCount()); 
     } 
     EasyMock.verify(wrapped, r); 
 } 
@Test 
 public void testNewThreadExHandler4911() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testNewThreadExHandler4953() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test(expected = NullPointerException.class) 
 public void testBuildWrappedFactoryNull5055() { 
     builder.wrappedFactory(null); 
 } 
@Test 
 public void testNewThreadExHandler5463() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testNewThreadExHandler5553() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testNewThreadExHandler5564() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testNewThreadExHandler5612() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testNewThreadExHandler5680() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testNewThreadExHandler5881() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testNewThreadExHandler6053() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testNewThreadExHandler6273() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testNewThreadExHandler6408() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testNewThreadExHandler6695() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testNewThreadExHandler6733() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testNewThreadExHandler6767() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testNewThreadExHandler6826() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testNewThreadExHandler7169() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testNewThreadNamingPattern7657() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final int count = 12; 
     for (int i = 0; i < count; i++) { 
         EasyMock.expect(wrapped.newThread(r)).andReturn(new Thread()); 
     } 
     EasyMock.replay(wrapped, r); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).namingPattern(PATTERN).build(); 
     for (int i = 0; i < count; i++) { 
         final Thread t = factory.newThread(r); 
         assertEquals("Wrong thread name", String.format(PATTERN, Long.valueOf(i + 1)), t.getName()); 
         assertEquals("Wrong thread count", i + 1, factory.getThreadCount()); 
     } 
     EasyMock.verify(wrapped, r); 
 } 
@Test 
 public void testNewThreadExHandler7701() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testNewThreadNamingPattern7832() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final int count = 12; 
     for (int i = 0; i < count; i++) { 
         EasyMock.expect(wrapped.newThread(r)).andReturn(new Thread()); 
     } 
     EasyMock.replay(wrapped, r); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).namingPattern(PATTERN).build(); 
     for (int i = 0; i < count; i++) { 
         final Thread t = factory.newThread(r); 
         assertEquals("Wrong thread name", String.format(PATTERN, Long.valueOf(i + 1)), t.getName()); 
         assertEquals("Wrong thread count", i + 1, factory.getThreadCount()); 
     } 
     EasyMock.verify(wrapped, r); 
 } 
@Test 
 public void testBuilderReset7848() { 
     final ThreadFactory wrappedFactory = EasyMock.createMock(ThreadFactory.class); 
     final Thread.UncaughtExceptionHandler exHandler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     EasyMock.replay(wrappedFactory, exHandler); 
     builder.namingPattern(PATTERN).daemon(true).priority(Thread.MAX_PRIORITY).uncaughtExceptionHandler(exHandler).wrappedFactory(wrappedFactory); 
     builder.reset(); 
     final BasicThreadFactory factory = builder.build(); 
     checkFactoryDefaults(factory); 
     assertNotSame("Wrapped factory not reset", wrappedFactory, factory.getWrappedFactory()); 
     EasyMock.verify(wrappedFactory, exHandler); 
 } 
@Test 
 public void testNewThreadNamingPattern8018() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final int count = 12; 
     for (int i = 0; i < count; i++) { 
         EasyMock.expect(wrapped.newThread(r)).andReturn(new Thread()); 
     } 
     EasyMock.replay(wrapped, r); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).namingPattern(PATTERN).build(); 
     for (int i = 0; i < count; i++) { 
         final Thread t = factory.newThread(r); 
         assertEquals("Wrong thread name", String.format(PATTERN, Long.valueOf(i + 1)), t.getName()); 
         assertEquals("Wrong thread count", i + 1, factory.getThreadCount()); 
     } 
     EasyMock.verify(wrapped, r); 
 } 
@Test 
 public void testNewThreadExHandler8076() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testBuilderReset8151() { 
     final ThreadFactory wrappedFactory = EasyMock.createMock(ThreadFactory.class); 
     final Thread.UncaughtExceptionHandler exHandler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     EasyMock.replay(wrappedFactory, exHandler); 
     builder.namingPattern(PATTERN).daemon(true).priority(Thread.MAX_PRIORITY).uncaughtExceptionHandler(exHandler).wrappedFactory(wrappedFactory); 
     builder.reset(); 
     final BasicThreadFactory factory = builder.build(); 
     checkFactoryDefaults(factory); 
     assertNotSame("Wrapped factory not reset", wrappedFactory, factory.getWrappedFactory()); 
     EasyMock.verify(wrappedFactory, exHandler); 
 } 
@Test 
 public void testNewThreadExHandler8155() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testNewThreadExHandler8177() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testNewThreadExHandler8332() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testNewThreadNamingPattern8466() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final int count = 12; 
     for (int i = 0; i < count; i++) { 
         EasyMock.expect(wrapped.newThread(r)).andReturn(new Thread()); 
     } 
     EasyMock.replay(wrapped, r); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).namingPattern(PATTERN).build(); 
     for (int i = 0; i < count; i++) { 
         final Thread t = factory.newThread(r); 
         assertEquals("Wrong thread name", String.format(PATTERN, Long.valueOf(i + 1)), t.getName()); 
         assertEquals("Wrong thread count", i + 1, factory.getThreadCount()); 
     } 
     EasyMock.verify(wrapped, r); 
 } 
@Test 
 public void testNewThreadExHandler8598() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testNewThreadExHandler8739() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testBuilderReset8900() { 
     final ThreadFactory wrappedFactory = EasyMock.createMock(ThreadFactory.class); 
     final Thread.UncaughtExceptionHandler exHandler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     EasyMock.replay(wrappedFactory, exHandler); 
     builder.namingPattern(PATTERN).daemon(true).priority(Thread.MAX_PRIORITY).uncaughtExceptionHandler(exHandler).wrappedFactory(wrappedFactory); 
     builder.reset(); 
     final BasicThreadFactory factory = builder.build(); 
     checkFactoryDefaults(factory); 
     assertNotSame("Wrapped factory not reset", wrappedFactory, factory.getWrappedFactory()); 
     EasyMock.verify(wrappedFactory, exHandler); 
 } 
@Test 
 public void testBuilderReset9077() { 
     final ThreadFactory wrappedFactory = EasyMock.createMock(ThreadFactory.class); 
     final Thread.UncaughtExceptionHandler exHandler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     EasyMock.replay(wrappedFactory, exHandler); 
     builder.namingPattern(PATTERN).daemon(true).priority(Thread.MAX_PRIORITY).uncaughtExceptionHandler(exHandler).wrappedFactory(wrappedFactory); 
     builder.reset(); 
     final BasicThreadFactory factory = builder.build(); 
     checkFactoryDefaults(factory); 
     assertNotSame("Wrapped factory not reset", wrappedFactory, factory.getWrappedFactory()); 
     EasyMock.verify(wrappedFactory, exHandler); 
 } 
@Test(expected = NullPointerException.class) 
 public void testBuildNamingPatternNull9274() { 
     builder.namingPattern(null); 
 } 
@Test 
 public void testNewThreadNamingPattern9309() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final int count = 12; 
     for (int i = 0; i < count; i++) { 
         EasyMock.expect(wrapped.newThread(r)).andReturn(new Thread()); 
     } 
     EasyMock.replay(wrapped, r); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).namingPattern(PATTERN).build(); 
     for (int i = 0; i < count; i++) { 
         final Thread t = factory.newThread(r); 
         assertEquals("Wrong thread name", String.format(PATTERN, Long.valueOf(i + 1)), t.getName()); 
         assertEquals("Wrong thread count", i + 1, factory.getThreadCount()); 
     } 
     EasyMock.verify(wrapped, r); 
 } 
@Test 
 public void testNewThreadExHandler9359() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
@Test 
 public void testNewThreadExHandler9434() { 
     final ThreadFactory wrapped = EasyMock.createMock(ThreadFactory.class); 
     final Runnable r = EasyMock.createMock(Runnable.class); 
     final Thread.UncaughtExceptionHandler handler = EasyMock.createMock(Thread.UncaughtExceptionHandler.class); 
     final Thread t = new Thread(); 
     EasyMock.expect(wrapped.newThread(r)).andReturn(t); 
     EasyMock.replay(wrapped, r, handler); 
     final BasicThreadFactory factory = builder.wrappedFactory(wrapped).uncaughtExceptionHandler(handler).build(); 
     assertSame("Wrong thread", t, factory.newThread(r)); 
     assertEquals("Wrong exception handler", handler, t.getUncaughtExceptionHandler()); 
     EasyMock.verify(wrapped, r, handler); 
 } 
