package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }
    @Test
    public void addNeighbourToFavWithSuccess(){
        Neighbour neighbourToAddToFav = service.getNeighbours().get(0);
        service.addFavoriteNeighbour(neighbourToAddToFav);
        assertTrue(service.getFavoriteNeighbours().contains(neighbourToAddToFav));
    }
    @Test
    public void removeNeighbourToFavWithSuccess(){
        Neighbour neighbourToRemoveToFav = service.getNeighbours().get(0);
        service.addFavoriteNeighbour(neighbourToRemoveToFav);
        service.removeFavoriteNeighbour(neighbourToRemoveToFav);
        assertFalse(service.getFavoriteNeighbours().contains(neighbourToRemoveToFav));
    }
    @Test
    public void createNeighbourWithSuccess(){
        Neighbour neighbourToCreate = new Neighbour(12, "test", "http://i.pravatar.cc/150?u=a042581f4e29026704d", "test", "test", "test", false);
        service.createNeighbour(neighbourToCreate);
        assertTrue(service.getNeighbours().contains(neighbourToCreate));
    }
}