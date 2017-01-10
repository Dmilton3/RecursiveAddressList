

/**
 * Created by Dewey Milton on 11/27/2016.
 * Purpose : Creates a Singly linked list
 * As an Address List, All methods are
 * done recursively
 */
public class AddressList {

    /*
        ListNode
        Creates a Node for the Linked List
     */
    private class ListNode
    {
        private String name;
        private String tel;   //Telephone numnber
        private String email;
        private String addr;     //Address
        private String dob;      //date of birth
        private ListNode next;   //pointer to the next node

        private ListNode(String name, String tel, String email, String addr, String dob)
        {
            this.name = name;
            this.tel = tel;
            this.email = email;
            this.addr = addr;
            this.dob = dob;
        }

        /*
            getName
            @Return name
         */
        public String getName(){
            return this.name;
        }

        /*
           getTel
           @return Telephone number
         */
        public String getTel(){
            return this.tel;
        }

        /*
           getEmail
           @return email
         */
        public String getEmail(){
            return this.email;
        }

        /*
           getAddr
           @return address
         */
        public String getAddr(){
            return this.addr;
        }

        /*
          getDob
          @return Date of Birth
         */
        public String getDob(){
            return this.dob;
        }

        /*
           toString
           @return String of linked list contents
         */
        public String toString(){
            return getName();
        }

        /*
          setName
          @param String name
          sets name
         */
        public void setName(String name){this.name = name;}

        /*
           setTel
           @param String Tel
           sets telephone number
         */
        public void setTel(String tel){ this.tel = tel; }

        /*
           setEmail
           @String email
           sets email
         */
        public void setEmail(String email){ this.email = email; }

        /*
          setAddr
          @param String addr
         */
        public void setAddr(String addr) { this.addr = addr;}

        /*
         setDob
         @param String dob
         sets date of birth
         */
        public void setDob(String dob) { this.dob = dob;}

        /*
          getNext
          @return next
          get next node
         */
        public ListNode getNext(){ return next; }

        /*
          setNext
          @oaram link
          setNext node
         */
        public void setNext(ListNode link) { next = link; }
    }



    /*
       isEmpty
       @return boolean if list empty
     */
     public boolean isEmpty(){
         boolean isEmpty = false;

         if(this.front == null){
             isEmpty = true;
         }

         return isEmpty;
     }

    /*
       addToFront
       @oaram String name
       @param String tel
       @param String email
       @param String addr
       @param String dob
       sets address to the front of list
     */
    public void addToFront(String name, String tel, String email, String addr, String dob){


        ListNode link = new ListNode(name, tel, email, addr, dob);

       // System.out.println("Created node link is " + link.toString());

        if(!isEmpty()){
            link.setNext(this.front);
        }
        else
        link.setNext(null);
        this.front = link;

       // System.out.println("Front is now " + front.toString());
    }

    /*
     addToBack
     @param String name
     @param String tel
     @param String email
     @param String addr
     @param String dob
     Sets address to back of the list
     */
    public void addToBack(String name, String tel, String email, String addr, String dob){
        ListNode link = new ListNode(name, tel, email, addr, dob);

       // System.out.println("Adding to back with link " + link.toString());
        if(!isEmpty()){
          ListNode Current = this.front;

          //  System.out.println("Current is " + Current.toString());
            if(Current.getNext() == null){
               // System.out.println("At the back Current is " + Current.toString());
                link.setNext(null);
                Current.setNext(link);
              //  System.out.println("Set the back as " + Current.getNext().toString());
            }
            else{
            //    System.out.println("First rec to back");
                recToBack(Current, link);
            }
        }
        else {
          //  System.out.println("empty, back is front");
            this.front = link;
            this.front.setNext(null);
        }

    }

    /*
       recToBack
       @param ListNode Current
       @param ListNode Link
       Calls itself until Current.next is null
     */
    private void recToBack(ListNode Current, ListNode link){
        if(Current.getNext() == null){
           // System.out.println("At the back Current is " + Current.toString());
            link.setNext(null);
            Current.setNext(link);
          //  System.out.println("Set the back as " + Current.getNext().toString());
        }
        else{
            Current = Current.getNext();
          //  System.out.println("Next Rec Current is " + Current.toString() + "Next up is " + Current.getNext());
            recToBack(Current, link);
        }
    }

    /*
      toString
      @return String
      returns string of list
     */
    public String toString(){
        String result = "";
        if(!isEmpty()){
            ListNode Current = this.front;
           // System.out.println("First to string, Current is " + Current.toString());
            result += Current.getName() + " " + Current.getTel() + " " + " " + Current.getAddr() +
                    " " + Current.getEmail() + " " +  Current.getDob() + "\n";
            if(Current.getNext() != null){
               // System.out.println("Going into RecString");
                Current = Current.getNext();
                result += recToString(Current, result);
            }
        }


        return result;


    }

    /*
       recToString
       @return String
       calls itself collecting String result of the list
     */
    private String recToString(ListNode Current, String result){
        result = Current.getName() + " " + Current.getTel() + " " + " " + Current.getAddr() +
                " " + Current.getEmail() + " "  + Current.getDob() + "\n";

        int num = 0;
      //  System.out.println("In Rec String num is " + num + " Current is " + Current.toString());
        if(Current.getNext() != null){
            Current = Current.getNext();
        //    System.out.println("Rec again Next is " + Current.toString());
            num++;
          //  System.out.println("in rec " + num);
            result += recToString(Current, result);
        }



        return result ;
    }

    /*
      reverseToString
      @return String
      Returns reverse string of the list
     */
    public String reverseToString(){
        String result = "";

        ListNode current = this.front;

        if(!isEmpty()) {
            if (current.getNext() != null) {
                result = revRecString(current);
            }

            result += current.getName() + " " + current.getTel() + " " + " " + current.getAddr() +
                    " " + current.getEmail() + " " + current.getDob() + "\n";

        }

        return result;
    }

    /*
      revRecString
      @param Current
      @return String
      calls itself collecting reverse toString
     */
    private String revRecString(ListNode current){
        String result = "";

        current = current.getNext();

        if(current.getNext() != null){
            result = revRecString(current);
        }

        result += current.getName() + " " + current.getTel() + " " + " " + current.getAddr() +
                " " + current.getEmail() + " " + current.getDob() + "\n";

        return result;
    }

    /*
      reverse
      @return AddressList
      reverses an address list
     */
    public AddressList reverse(){
        AddressList newList = new AddressList();

        if(!isEmpty()){
            ListNode current = this.front;
            newList.addToFront(current.getName(), current.getTel(), current.getEmail(),
                    current.getAddr(), current.getDob());
            newList = revList(current, newList);
        }

        return newList;
    }

    /*
       revList
       @param ListNode Current
       @param AddressList
       @return AddressList
        calls itself creating a new address list in reverse
     */
    private AddressList revList(ListNode current, AddressList newList){

        current = current.getNext();

        newList.addToFront(current.getName(), current.getTel(), current.getEmail(),
                current.getAddr(), current.getDob());

        if(current.getNext() != null){
            newList = revList(current, newList);
        }

        return newList;
    }

    /*
       sizeOf
       @return int
       return size of list
     */
    public int sizeOf(){
        int size = 0;

        ListNode current = this.front;

        if(!isEmpty()){
            size = recCount(current);
            size++;
        }

        return size;
    }

    /*
       recCount
       @param ListNode Current
       @return in
       calls itself counting each node
     */
    private int recCount(ListNode current){
        int size = 0;
        current = current.getNext();

        if(current.getNext() != null){
            size = recCount(current);
        }

        size++;

        return size;
    }

    /*
       phoneNumberByName
       @param String name
       @return String tel
       returns phone number by given name
     */
    public String phoneNumberByName(String name){
        String phone = "";

        ListNode current = this.front;

        if(!isEmpty()){

            if(current.getName().equalsIgnoreCase(name)){
                phone = current.getTel();
            }
            else if(current.getNext() != null){
                current = current.getNext();
                phone = recTel(current, name);
            }
            else{
                phone = "No matching data";
            }
        }
        else
            phone = "No matching data";

        return phone;
    }

    /*
       recTel
       @param ListNode Current
       @param String name
       @return String tel
       calls itself until name matches and returns telephone number
     */
     private String recTel(ListNode current, String name){
         String phone = "";

         if(current.getName().equalsIgnoreCase(name)){
             phone = current.getTel();
         }
         else if(current.getNext() != null){
             current = current.getNext();
             phone = recTel(current, name);
         }
         else{
             phone = "No matching data";
         }

         return phone;
     }

    /*
        emailByName
        @param String name
        @return String email
     */
    public String emailByName(String name){
        String email = "";

        ListNode current = this.front;

        if(!isEmpty()){

            if(current.getName().equalsIgnoreCase(name)){
                email = current.getEmail();
            }
            else if(current.getNext() != null){
                current = current.getNext();
                email = recEmail(current, name);
            }
            else{
                email = "No matching data";
            }
        }
        else
            email = "No matching data";

        return email;
    }

    /*
       recEmail
       @param ListNode Current
       @param String name
       @return String email
     */
    private String recEmail(ListNode current, String name){
        String email = "";

        if(current.getName().equalsIgnoreCase(name)){
            email = current.getEmail();
        }
        else if(current.getNext() != null){
            current = current.getNext();
            email = recEmail(current, name);
        }
        else{
            email = "No matching data";
        }

        return email;
    }

    /*
       dobByName
       @param String name
       @return String dob
       returns date of birth by given name
     */
    public String dobByName(String name){
        String dob = "";

        ListNode current = this.front;

        if(!isEmpty()){

            if(current.getName().equalsIgnoreCase(name)){
                dob = current.getDob();
            }
            else if(current.getNext() != null){
                current = current.getNext();
                dob = recDob(current, name);
            }
            else{
                dob = "No matching data";
            }
        }
        else
            dob = "No matching data";

        return dob;
    }

    /*
       recDob
       @param ListNode Current
       @param String name
       @return String dob
     */
    private String recDob(ListNode current, String name){
        String dob = "";

        if(current.getName().equalsIgnoreCase(name)){
            dob = current.getDob();
        }
        else if(current.getNext() != null){
            current = current.getNext();
            dob = recDob(current, name);
        }
        else{
            dob = "No matching data";
        }

        return dob;
    }

    /*
       nameByPhoneNumber
       @param String tel
       @return String Name
       returns name associated by given telephone number
     */
    public String nameByPhoneNumber(String tel){
        String name = "";

        ListNode current = this.front;

        if(!isEmpty()){

            if(current.getTel().compareTo(tel) == 0){
                name = current.getName();
            }
            else if(current.getNext() != null){
                current = current.getNext();
                name = recName(current, tel);
            }
            else{
                name = "No matching data";
            }
        }
        else
            name = "No matching data";

        return name;
    }

    /*
      recName
      @param ListNode Current
      @param String tel
      @return String name
     */
    private String recName(ListNode current, String tel){
        String name = "";

        if(current.getTel().compareTo(tel) == 0){
            name = current.getName();
        }
        else if(current.getNext() != null){
            current = current.getNext();
            name = recName(current, tel);
        }
        else{
            name = "No matching data";
        }

        return name;
    }


    private ListNode front;

    public AddressList(){

        this.front = null;

    }
}
