package hotelService;

import java.time.LocalDate;
import java.util.List;

public class Room {
    private final int numberOfRoom;
    private final int howManyPersonCanCheckIn;
    private final boolean isBathroom;
    private boolean available = true;
    private List<Guest> guests;
    private boolean clean = true;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    public Room(int numberOfRoom, int howManyPersonCanCheckIn, boolean isBathroom) {
        this.numberOfRoom = numberOfRoom;
        this.howManyPersonCanCheckIn = howManyPersonCanCheckIn;
        this.isBathroom = isBathroom;
    }

    public int getNumberOfRoom() {
        return numberOfRoom;
    }

    public boolean isAvailable() {
        return available;
    }

    public boolean isClean() {
        return clean;
    }

    public int getHowManyPersonCanCheckIn() {
        return howManyPersonCanCheckIn;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setClean(boolean clean) {
        this.clean = clean;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        return "Room{" +
                "numberOfRoom=" + numberOfRoom +
                ", howManyPersonCanCheckIn=" + howManyPersonCanCheckIn +
                ", isBathroom=" + isBathroom +
                ", isAvailable=" + available +
                '}';
    }
}
