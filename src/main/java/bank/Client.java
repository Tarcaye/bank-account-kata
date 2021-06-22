package bank;

class Client {
    private final int id;

    public Client(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Client: "+ id;
    }
}
