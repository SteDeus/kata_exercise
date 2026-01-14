
public class TennisGame1 implements TennisGame {
    //bad name
    private int m_score1 = 0;
    //bad name
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        //magic string
    	//assunzione errata (player1 potrebbe non essere il nome registrato in player1Name)
    	if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    //SRP: oltre che a recuperare lo score, il metodo si occupa anche di calcolare calcolare la giusta rappresentazione dello stesso
    //il metodo è troppo lungo
    //complessita ciclomatica elevata
    public String getScore() {
        //utilizzo degli spazi orizzontali non coerente 
    	String score = "";
        //variabile dichiarata lontano dal punto di utilizzo
    	int tempScore=0;
        if (m_score1==m_score2)
        {
        	//magic value & strings
            switch (m_score1)
            {
                case 0:
                        score = "Love-All";
                    break;
                case 1:
                        score = "Fifteen-All";
                    break;
                case 2:
                        score = "Thirty-All";
                    break;
                default:
                        score = "Deuce";
                    break;
                
            }
        }
        //incapsulamento condizione
        else if (m_score1>=4 || m_score2>=4)
        {
        	//nome poco chiaro
            int minusResult = m_score1-m_score2;
            //incapsulamento condizione
            if (minusResult==1) score ="Advantage player1";
            //incapsulamento condizione
            else if (minusResult ==-1) score ="Advantage player2";
            //incapsulamento condizione
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {	//magic number (perché 3?)
            for (int i=1; i<3; i++)
            {
            	//if & else inline
            	//incapsulamento condizione
                if (i==1) tempScore = m_score1;
                else { score+="-"; tempScore = m_score2;}
                switch(tempScore)
                {
                    case 0:
                        score+="Love";
                        break;
                    case 1:
                        score+="Fifteen";
                        break;
                    case 2:
                        score+="Thirty";
                        break;
                    case 3:
                        score+="Forty";
                        break;
                }
            }
        }
        return score;
    }
}
