
public class TennisGame2 implements TennisGame
{
	//scope variabili
    public int P1point = 0;
    public int P2point = 0;
    
    //scope variabili
    //nome non chiaro
    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    //metodo troppo lungo
    public String getScore(){
        String score = "";
        
        //incapsulamento condizioni
        if (P1point == P2point && P1point < 4)
        {
            if (P1point==0)
                score = "Love";
            if (P1point==1)
                score = "Fifteen";
            if (P1point==2)
                score = "Thirty";
            score += "-All";
        }
        //incapsulamento condizioni
        //utilizzo spaziatura verticale
        //utilizzo delle parentesi {
        if (P1point==P2point && P1point>=3)
            score = "Deuce";
        //incapsulamento condizioni
        if (P1point > 0 && P2point==0)
        {	//duplicazione del codice
            if (P1point==1)
                P1res = "Fifteen";
            if (P1point==2)
                P1res = "Thirty";
            if (P1point==3)
                P1res = "Forty";
            
            P2res = "Love";
            score = P1res + "-" + P2res;
        }
        //incapsulamento condizioni
        if (P2point > 0 && P1point==0)
        {	//duplicazione del codice
            if (P2point==1)
                P2res = "Fifteen";
            if (P2point==2)
                P2res = "Thirty";
            if (P2point==3)
                P2res = "Forty";
            
            P1res = "Love";
            score = P1res + "-" + P2res;
        }
        //incapsulamento condizioni
        if (P1point>P2point && P1point < 4)
        {
        	//duplicazione del codice
            if (P1point==2)
                P1res="Thirty";
            if (P1point==3)
                P1res="Forty";
            if (P2point==1)
                P2res="Fifteen";
            if (P2point==2)
                P2res="Thirty";
            score = P1res + "-" + P2res;
        }
        //incapsulamento condizioni
        if (P2point>P1point && P2point < 4)
        {
        	//duplicazione del codice
            if (P2point==2)
                P2res="Thirty";
            if (P2point==3)
                P2res="Forty";
            if (P1point==1)
                P1res="Fifteen";
            if (P1point==2)
                P1res="Thirty";
            score = P1res + "-" + P2res;
        }
        
        //incapsulamento condizioni
        //numero espressioni da valutare (complessità ciclomatica)
        if (P1point > P2point && P2point >= 3)
        {
            score = "Advantage player1";
        }
        //incapsulamento condizioni
        //numero espressioni da valutare (complessità ciclomatica)
        if (P2point > P1point && P1point >= 3)
        {
            score = "Advantage player2";
        }
        //incapsulamento condizioni
        //numero espressioni da valutare (complessità ciclomatica)
        if (P1point>=4 && P2point>=0 && (P1point-P2point)>=2)
        {
            score = "Win for player1";
        }
        //incapsulamento condizioni
        //numero espressioni da valutare (complessità ciclomatica)
        if (P2point>=4 && P1point>=0 && (P2point-P1point)>=2)
        {
            score = "Win for player2";
        }
        return score;
    }
    
    //Codice non necessario
    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
            
    }
    
    //Codice non necessario
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P2Score();
        }
            
    }
    
    public void P1Score(){
        P1point++;
    }
    
    public void P2Score(){
        P2point++;
    }

    public void wonPoint(String player) {
    	//magic string
    	//assunzione errata (player1 potrebbe non essere il nome registrato in player1Name)
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}