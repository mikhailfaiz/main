package seedu.volant.itinerary.model;

import static java.util.Objects.requireNonNull;
import static seedu.volant.commons.logic.Page.ITINERARY;
import static seedu.volant.commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;

import seedu.volant.commons.core.GuiSettings;
import seedu.volant.commons.logic.Page;
import seedu.volant.commons.model.Model;
import seedu.volant.commons.model.ReadOnlyUserPrefs;
import seedu.volant.commons.model.UserPrefs;
import seedu.volant.home.model.TripList;
import seedu.volant.home.model.trip.Trip;
import seedu.volant.trip.model.Itinerary;
import seedu.volant.trip.model.TripFeature;

/**
 * Handles in app memory when user is in an ITINERARY page.
 */
public class ItineraryModelManager implements Model {

    private final TripList tripList;
    private final Trip trip;
    private final Itinerary itinerary;
    private final UserPrefs userPrefs;
    private final Page page = ITINERARY;

    /**
     * Constructs an ItineraryModelManager that helps to keep track of in application memory.
     * @param tripList keeps track of trip list to go back to.
     * @param trip keeps track of trip that itinerary list is in from.
     */
    public ItineraryModelManager(TripList tripList, Trip trip, Itinerary itinerary, ReadOnlyUserPrefs userPrefs) {
        requireAllNonNull(tripList, trip, userPrefs);

        LOGGER.fine("You are now in the ITINERARY page of TRIP: " + trip + ".");

        this.tripList = tripList;
        this.trip = trip;
        this.itinerary = itinerary;
        this.userPrefs = new UserPrefs(userPrefs);
    }

    @Override
    public Page getPage() {
        return page;
    }

    public TripList getTripList() {
        return tripList;
    }

    public Trip getTrip() {
        return trip;
    }

    public TripFeature getItinerary() {
        return itinerary;
    }

    public ActivityList getActivityList() {
        return itinerary.getActivityList();
    }

    //=========== UserPrefs ==================================================================================

    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        requireNonNull(userPrefs);
        this.userPrefs.resetData(userPrefs);
    }

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        return userPrefs;
    }

    @Override
    public GuiSettings getGuiSettings() {
        return userPrefs.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        userPrefs.setGuiSettings(guiSettings);
    }

    @Override
    public Path getVolantFilePath() {
        return userPrefs.getVolantFilePath();
    }

    @Override
    public void setVolantFilePath(Path volantFilePath) {
        requireNonNull(volantFilePath);
        userPrefs.setVolantFilePath(volantFilePath);
    }
}