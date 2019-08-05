package innerclasses;

public class RadioModule {

    public RadioModule(){
        System.out.println("RadioModule initialize");
    }

    public void call(String number){

        int length = 10;

        class CSMModule{

            private String phoneNumber;
            private int validNumber;

            public CSMModule(String phoneNumber){
                this.phoneNumber = phoneNumber;
            }

            public boolean isValid(){
                if (phoneNumber.length()!=length){
                    return false;
                } else{
                    try {
                        validNumber = Integer.parseInt(phoneNumber);
                                return true;
                    } catch (NumberFormatException e){
                        return false;
                    }
                }
            }
            public void dialIn(){
                if (isValid()){
                    System.out.println("Calling phone number " + validNumber);
                } else {
                    System.out.println("Phone Numbe is invalid");
                }
            }
        } CSMModule module = new CSMModule(number);
            module.dialIn();



    }
}
