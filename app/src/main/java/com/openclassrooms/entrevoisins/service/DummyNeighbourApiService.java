package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    /**
     * {@inheritDoc}
     * @param neighbour
     */
    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }


    /**
     * {@inheritDoc}
     */



    /**
     * {@inheritDoc}
     * @param neighbour
     */
    @Override

    public void addFavoriteNeighbour(Neighbour neighbour) {
        neighbour.setFavorite(true);
    }
    /**
     * {@inheritDoc}
     * @param neighbour
     */
    @Override
    public void removeFavoriteNeighbour (Neighbour neighbour) {
        neighbour.setFavorite(false);
    }
    @Override
    public ArrayList<Neighbour> getFavoriteNeighbours() {
        ArrayList<Neighbour> favoriteNeighbours = new ArrayList<>();
        for (Neighbour i : neighbours) {
            if (i.getFavorite()) {
                favoriteNeighbours.add(i);
            }
        }
        return favoriteNeighbours;
    }

    @Override
    public Neighbour getNeighbour(long id) {
        Neighbour neighbour = null;
        for(Neighbour i : neighbours) {
            if(i.getId() == id){
                neighbour = i;
                break;
            }
        }
        return neighbour;
    }



}
