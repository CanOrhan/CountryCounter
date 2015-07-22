package uk.co.kiwisoft.tomtom;

import java.util.ArrayList;

/**
 * Created by Can Orhan on 22/07/15.
 */
public class CountriesService {
    private final int width;
    private int countries = 0;
    private final ArrayList<Node> nodes = new ArrayList<>();

    public CountriesService(int width){
        this.width = width;
    }

    public void addNode(Node node){
        nodes.add(node);
    }

    public int calculate() {
        countries = 0;
        for(Node node : nodes){
            checkSurrounding(node);
        }
        nodes.removeAll(nodes);
        return countries;
    }

    private void checkSurrounding(Node node){
        int rightNodeIndex = nodes.indexOf(new Node(node.getX() + 1, node.getY(), 0));
        boolean checkRight = rightNodeIndex != -1;

        int downNodeIndex = nodes.indexOf(new Node(node.getX(), node.getY() + 1, 0));
        boolean checkDown = downNodeIndex != -1;

        if (!node.isClaimed()){
            countries += 1;
        }

        if(checkRight){
            Node rightNode = nodes.get(rightNodeIndex);
            if(rightNode.getColor() == node.getColor()){
                if(!rightNode.isClaimed()){
                    rightNode.setIsClaimed(true);
                }
            }
        }

        if(checkDown){
            Node downNode = nodes.get(downNodeIndex);
            if(downNode.getColor() == node.getColor()){
                if(!downNode.isClaimed()){
                    downNode.setIsClaimed(true);
                }
            }
        }
    }
}
