//class Solution {
//
//           public boolean isOneEditDistance(String s, String t) {
//               int abs = Math.abs(s.length() - t.length());
//               if(abs > 1){
//                   return false;
//               }
//               int countDiff1 = 0;
//               if(abs == 0){
//                   for(int  i = 0; i < s.length(); i++){
//                       if(s.charAt(i) != t.charAt(i)) {
//                           countDiff1++;
//                           if(countDiff1 > 1){
//                               return false;
//                           }
//                       }
//                   }
//               }
//               if(abs == 1){
//
//               }
//
//            }
//}