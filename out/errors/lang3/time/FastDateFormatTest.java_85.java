@Test
public void testParseSync11050() throws InterruptedException { 
         final String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS Z"; 
         final FastDateFormat formatter= FastDateFormat.getDateInstance(pattern); 
          
         final long sdfTime= measureTime(formatter, new SimpleDateFormat(pattern) { 
                         private static final long serialVersionUID = 1L;  // because SimpleDateFormat is serializable 
  
                         @Override 
                         public Object parseObject(final String formattedDate) throws ParseException { 
                             synchronized(this) { 
                                 return super.parse(formattedDate); 
                             } 
                         } 
         }); 
          
         final long fdfTime= measureTime(formatter, FastDateFormat.getDateInstance(pattern)); 
          
         final String times= ">>FastDateFormatTest: FastDateParser:"+fdfTime+"  SimpleDateFormat:"+sdfTime; 
         System.out.println(times); 
     } 
  
     final static private int NTHREADS= 10; 
      
     final static private int NROUNDS= 10000; 
      
     private long measureTime(final Format formatter, final Format parser) throws InterruptedException { 
         final ExecutorService pool = Executors.newFixedThreadPool(NTHREADS); 
         final AtomicInteger failures= new AtomicInteger(0); 
         final AtomicLong totalElapsed= new AtomicLong(0); 
          
         for(int i= 0; i<NTHREADS; ++i) { 
             pool.submit(new Runnable() { 
                 @Override 
                 public void run() { 
                     for(int i= 0; i<NROUNDS; ++i) { 
                         try { 
                             final Date date= new Date(); 
                             final String formattedDate= formatter.format(date); 
                             final long start= System.currentTimeMillis();         
                             final Object pd= parser.parseObject(formattedDate); 
                             total