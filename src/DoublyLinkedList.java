public class DoublyLinkedList {
    private Song head;
    private Song tail;
    private Song current;

    public void addSong(String title){
        Song newSong = new Song(title);

        if(head == null){
            head = newSong;
            tail = newSong;
            current = newSong;
        }
        else{
            tail.next = newSong;
            newSong.prev = tail;
            tail = newSong;
        }
    }


    public void nextSong(){
        if (current != null && current.next != null){
            current = current.next;
            System.out.println("Now playing " + current.title);
        }
        else{
            System.out.println("End of playlist.");
        }
    }

    public void previousSong(){
        if (current != null && current.prev != null){
            current = current.prev;
            System.out.println("Now playing " + current.title);
        }
        else{
            System.out.println("Start of playlist.");
        }
    }


    public void printPLaylist(){
        Song temp = head;
        while(temp != null){
            System.out.println(temp.title);
            System.out.println("...");
            temp = temp.next;
        }
    }


    public void removeCurrent(){
        if(current == null){
            System.out.println("Removing " + current.title);
        }

        if(current.prev != null){
            current.prev.next = current.next;
        }
        head = current.next;

        if(current.next != null){
            current.next.prev = current.prev;
        }
        tail = current.prev;
    }

    public void playCurrent(){
        System.out.println("Playing " + current.title);
    }

}