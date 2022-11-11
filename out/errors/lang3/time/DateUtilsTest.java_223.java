@Test
public void testWeekIterator10892() throws Exception { 
         final Calendar now = Calendar.getInstance(); 
         for (int i = 0; i< 7; i++) { 
             final Calendar today = DateUtils.truncate(now, Calendar.DATE); 
             final Calendar sunday = DateUtils.truncate(now, Calendar.DATE); 
             sunday.add(Calendar.DATE, 1 - sunday.get(Calendar.DAY_OF_WEEK)); 
             final Calendar monday = DateUtils.truncate(now, Calendar.DATE); 
             if (monday.get(Calendar.DAY_OF_WEEK) == 1) { 
                 //This is sunday... roll back 6 days 
                 monday.add(Calendar.DATE, -6); 
             } else { 
                 monday.add(Calendar.DATE, 2 - monday.get(Calendar.DAY_OF_WEEK)); 
             } 
             final Calendar centered = DateUtils.truncate(now, Calendar.DATE); 
             centered.add(Calendar.DATE, -3); 
              
             Iterator<?> it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_SUNDAY); 
             assertWeekIterator(it, sunday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_MONDAY); 
             assertWeekIterator(it, monday); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_RELATIVE); 
             assertWeekIterator(it, today); 
             it = DateUtils.iterator(now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now, DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             it = DateUtils.iterator((Object) now.getTime(), DateUtils.RANGE_WEEK_CENTER); 
             assertWeekIterator(it, centered); 
             try {