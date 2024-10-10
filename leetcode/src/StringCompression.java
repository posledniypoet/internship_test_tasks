class StringCompression {
    public int compress(char[] chars) {
        int newLength = 0;
        char leftChar = 'x';
        int count = 1;
        int index = 0;
        if(chars.length == 0){
            return 0;
        }
        if(chars.length == 1){
            return 1;
        }
        for(int i = 0; i < chars.length; i++){
            if(i == 0){
                leftChar = chars[i];
            } else{
                if(chars[i] == leftChar){
                    count++;
                } else{
                    if(count == 1){
                        chars[index] = leftChar;
                        index++;
                    } else{
                        chars[index] = leftChar;
                        index++;
                        if(String.valueOf(count).length() == 1){
                            chars[index] = (char) (count + '0');
                            index++;
                        } else {
                            String value = String.valueOf(count);
                            for(int j = 0 ; j < String.valueOf(count).length(); j++){
                                chars[index] = value.charAt(j);
                                index++;
                            }
                        }
                    }
                    leftChar = chars[i];
                    newLength += 1;
                    if(count != 1){
                        newLength += String.valueOf(count).length();
                    }
                    count = 1;
                }
            }
        }
        if(count == 1){
            chars[index] = leftChar;
            index++;
        } else{
            chars[index] = leftChar;
            index++;
            if(String.valueOf(count).length() == 1){
                chars[index] = (char) (count + '0');
            } else {
                String value = String.valueOf(count);
                for(int j = 0 ; j < String.valueOf(count).length(); j++){
                    chars[index] = value.charAt(j);
                    index++;
                }
            }
        }
        newLength += 1;
        if(count != 1){
            newLength += String.valueOf(count).length();
        }
        return newLength;
    }
}