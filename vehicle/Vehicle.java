package vehicle;


public abstract class Vehicle{
    private final String licence_no;
    private final VehicleSize size;

    public Vehicle(String licence_no, VehicleSize size){
        this.licence_no = licence_no;
        this.size = size;
    }

    public String get_licence_no(){return licence_no;}
    public VehicleSize get_size(){return size;}

}

