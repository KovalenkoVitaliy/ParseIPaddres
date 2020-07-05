public class IPaddres {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] netAddress = new byte[4];
        for (int i =0; i < ip.length; i++) {
            netAddress[i] = (byte) ((byte) ip[i] & (byte) mask[i]);
        }
        return netAddress;
    }

    public static void print(byte[] bytes) {
        int[] array = new int[bytes.length];
        for (int i=0; i < bytes.length; i++) {
            if (bytes[i]<0) {
                int t = bytes[i] + 256;
                array[i] = t;
            } else {
                array[i] = bytes[i];
            }

        }
        int del = 2;
        int chastn = 0;
        int ostatok = 0;
        String s = "";
        String bin = "";
        boolean flag = true;
        for (int i = 0; i<array.length; i++) {
            s = "";
            int chet =0;
            int a = array[i];
            while(flag) {
                if (a==0) {
                    s = "00000000";
                    break;
                } else if (a==1) {
                    s = "00000001";
                    break;
                }
                chastn = (a /del);
                ostatok = (a - (chastn * del));
                s = ostatok + s;
                /*
                if (chet ==3) {
                    s = " " + s;
                }
                 */
                a = chastn;
                if (chastn==1) {
                    s = chastn + s;
                    if (s.length()!=8) {
                        int dlina = s.length();
                        for (int j =0; j < 8-dlina; j++) {
                            s = 0 + s;
                        }
                    }
                    flag = false;
                }
                chet++;
            }
            flag = true;
            bin = bin + s + " ";
        }
        System.out.println(bin);
    }
}

