package player;

public class Defender extends Player {
    private int blocks;
    private int tackles;
    private int totalBlocks;
    private int totalTackles;
    public Defender() {
        this.blocks = 0;
        this.tackles = 0;
        this.totalBlocks = 0;
        this.totalTackles = 0;
    }
    public Defender(String name,String club){
        super(name,club);
        this.blocks = 0;
        this.tackles = 0;
        this.totalBlocks = 0;
        this.totalTackles = 0;
    }
    public int getBlocks(){
        return blocks;
    }
    public int getTackles(){
        return tackles;
    }
    public void blockPlayer() {
        blocks++;
        totalBlocks++;
    }
    public void tacklePlayer() {
        tackles++;
        totalTackles++;
    }
    public void playMatch(int blocksForMatch,int tacklesForMatch){
        for(int i=0;i<blocksForMatch;i++){
            blockPlayer();
        }
        for(int i=0;i<tacklesForMatch;i++){
            tacklePlayer();
        }
        super.playMatch();
    }
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Total Blocks: "+totalBlocks);
        System.out.println("TotalTackles: "+totalTackles);
        System.out.println("Blocks Per Match: "+(double)totalBlocks/getMatches());
    }
}
