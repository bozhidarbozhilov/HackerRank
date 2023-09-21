package medium.visitorpattern;

import java.util.ArrayList;
import java.util.*;

import java.util.Scanner;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis {
    public abstract int getResult();

    public abstract void visitNode(TreeNode node);

    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    int leafSum = 0;

    public int getResult() {

        return leafSum;
    }

    public void visitNode(TreeNode node) {
    }

    public void visitLeaf(TreeLeaf leaf) {
        leafSum += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
   long product = 1L;
    public int getResult() {
        //implement this
        return (int) product;
    }

    public void visitNode(TreeNode node) {
        //implement this
        if(node.getColor().equals(Color.RED)){
            product = (product * node.getValue()) % (int) (Math.pow(10, 9) + 7);
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
        if(leaf.getColor().equals(Color.RED)){
            product = (product * leaf.getValue()) % (int) (Math.pow(10, 9) + 7);
        }
    }
}

class FancyVisitor extends TreeVis {
    int nodeSum;
    int greenLeafSum;
    public int getResult() {
        //implement this
        return Math.abs(greenLeafSum - nodeSum);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            nodeSum += node.getValue();
        }
        //implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
        if(leaf.getColor().equals(Color.GREEN)){
            greenLeafSum += leaf.getValue();
        }

    }
}
class NodeInfo {
    Integer value;
    Color color;
    Integer depth;
    List<Integer> children;
    Integer parent;

    public NodeInfo(Integer value, Color color, Integer depth, List<Integer> children, Integer parent) {
        this.value = value;
        this.color = color;
        this.depth = depth;
        this.children = children;
        this.parent = parent;
    }

}

public class Solution {

    private static Color getColor(String colorSymbol){
        return colorSymbol.equals("0") ? Color.RED : Color.GREEN;
    }

    public static Tree solve(){
        Scanner sc = new Scanner(System.in);
        int numOfNodes = Integer.parseInt(sc.nextLine());
        String[] inputValues = sc.nextLine().split("\\s");
        String[] colorsValue = sc.nextLine().split("\\s");
        List<String> edges = new ArrayList<>();
        NodeInfo[] rawNodes = new NodeInfo[numOfNodes];
        List<Tree> tree = new ArrayList<>(Collections.nCopies(numOfNodes, null));

        rawNodes[0] = new NodeInfo(Integer.parseInt(inputValues[0]), getColor(colorsValue[0]), 0, new ArrayList<>(), -1);
        for (int i = 1; i < numOfNodes; i++) {
            int value = Integer.parseInt(inputValues[i]);
            Color color = getColor(colorsValue[i]);
            NodeInfo tmp = new NodeInfo(value, color, -1, new ArrayList<>(), -1);
            rawNodes[i]=tmp;
        }
        for (int i = 0; i < numOfNodes - 1; i++) {
            String line = sc.nextLine();
            edges.add(line);
        }
        while(!edges.isEmpty()){
            boolean isSet = false;
            String currentEdge = null;
            for(String edge : edges){
                currentEdge = edge;
                String[] indexes = edge.split("\\s");
                int firstIndex = Integer.parseInt(indexes[0])-1;
                int secondIndex = Integer.parseInt(indexes[1])-1;
                int parentIndex = -1;
                int childIndex=-1;
                if(rawNodes[firstIndex].depth >= 0){
                    if (rawNodes[secondIndex].depth >= 0) {
                        parentIndex = rawNodes[firstIndex].depth < rawNodes[secondIndex].depth ? firstIndex : secondIndex;
                    } else {
                        parentIndex = firstIndex;
                    }
                }else if(rawNodes[secondIndex].depth >= 0) {
                    parentIndex = secondIndex;
                }
                if(parentIndex >= 0){
                    childIndex = parentIndex==secondIndex ? firstIndex : secondIndex;
                    NodeInfo parent = rawNodes[parentIndex];
                    NodeInfo child = rawNodes[childIndex];
                    parent.children.add(childIndex);
                    child.depth = parent.depth + 1;
                    child.parent = parentIndex;
                    isSet = true;
                    break;
                }
            }
            if (isSet) {
                edges.remove(currentEdge);
            }

        }
        fillTree(rawNodes, tree, 0);
        return tree.get(0);
    }

    private static void fillTree(NodeInfo[] rawNodes, List<Tree> tree, int index) {
        if(rawNodes[index].children.isEmpty()){
            NodeInfo leafInfo = rawNodes[index];
            TreeNode parent = (TreeNode) tree.get(leafInfo.parent);
            TreeLeaf child = new TreeLeaf(leafInfo.value, leafInfo.color, leafInfo.depth);
            parent.addChild(child);
            tree.set(index, child);
            return;
        }

        NodeInfo newNodeInfo = rawNodes[index];
        TreeNode parent;

        TreeNode newNode = new TreeNode(newNodeInfo.value, newNodeInfo.color,newNodeInfo.depth);
        tree.set(index, newNode);
        if(index > 0){
            parent = (TreeNode) tree.get(newNodeInfo.parent);
            parent.addChild(newNode);
        }


        for(Integer child : rawNodes[index].children){

            fillTree(rawNodes, tree, child);
        }

    }


//    public static Tree solve1() {
//        //read the tree from STDIN and return its root as a return value of this function
//        Scanner sc = new Scanner(System.in);
//        int numOfNodes = Integer.parseInt(sc.nextLine());
//        String[] inputValues = sc.nextLine().split("\\s");
//        String[] colorsValue = sc.nextLine().split("\\s");
//        List<String> edges = new ArrayList<>();
//        NodeInfo[] rawNodes = new NodeInfo[numOfNodes];
//        List<Tree> tree = new ArrayList<>();
//
//        rawNodes[0] = new NodeInfo(Integer.parseInt(inputValues[0]), getColor(colorsValue[0]), 0, new ArrayList<>(), );
//        for (int i = 1; i < numOfNodes; i++) {
//            int value = Integer.parseInt(inputValues[i]);
//            Color color = getColor(colorsValue[i]);
//            NodeInfo tmp = new NodeInfo(value, color, -1, new ArrayList<>());
//            rawNodes[i]=tmp;
//        }
//        for (int i = 0; i < numOfNodes - 1; i++) {
//            String line = sc.nextLine();
//            edges.add(line);
//        }
//
//        while(!edges.isEmpty()){
//            boolean isSet = false;
//            String currentEdge = null;
//            for(String edge : edges){
//                currentEdge = edge;
//                String[] indexes = edge.split("\\s");
//                int firstIndex = Integer.parseInt(indexes[0])-1;
//                int secondIndex = Integer.parseInt(indexes[1])-1;
//                int parentIndex = -1;
//                int childIndex=-1;
//                if(rawNodes[firstIndex].depth >= 0){
//                    if (rawNodes[secondIndex].depth >= 0) {
//                        parentIndex = rawNodes[firstIndex].depth < rawNodes[secondIndex].depth ? firstIndex : secondIndex;
//                    } else {
//                        parentIndex = firstIndex;
//                    }
//                }else if(rawNodes[secondIndex].depth >= 0) {
//                    parentIndex = secondIndex;
//                }
//                if(parentIndex >= 0){
//                    childIndex = parentIndex==secondIndex ? firstIndex : secondIndex;
//                    NodeInfo parent = rawNodes[parentIndex];
//                    NodeInfo child = rawNodes[childIndex];
//                    parent.children.add(childIndex);
//                    child.depth = parent.depth + 1;
//                    isSet = true;
//                    break;
//                }
//            }
//            if (isSet) {
//                edges.remove(currentEdge);
//            }
//
//        }
//        NodeInfo rootInfo = rawNodes[0];
//        tree.add(new TreeNode(rootInfo.value,rootInfo.color,0));
//
//        for (int i = 1; i < numOfNodes; i++) {
//            NodeInfo currentNode = rawNodes[i];
//            if(!currentNode.children.isEmpty()){
//                tree.add(i, new TreeNode(currentNode.value, currentNode.color, currentNode.depth));
//
//            }else{
//                tree.add(i, new TreeLeaf(currentNode.value, currentNode.color,currentNode.depth));
//            }
//        }
//
//        for (int i = 0; i < numOfNodes; i++) {
//            Tree currentNode = tree.get(i);
//            NodeInfo nodeInfo = rawNodes[i];
//            if(!nodeInfo.children.isEmpty()){
//                for(Integer childIndex : nodeInfo.children){
//                    ((TreeNode) currentNode).addChild(tree.get(childIndex));
//                }
//            }
//        }
//       return tree.get(0);
//    }


    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
