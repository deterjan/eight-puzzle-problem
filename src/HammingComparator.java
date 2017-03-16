import java.util.Comparator;

/**
 * Created by deniz on 15/03/17.
 */
public class HammingComparator implements Comparator<EightPuzzle>
{
    private static final EightPuzzle GOAL_STATE = new EightPuzzle();

    public int compare(EightPuzzle x, EightPuzzle y)
    {
        return computeHamming( x) - computeHamming( y);
    }

    public static int computeHamming( EightPuzzle puz)
    {
        int misplaced = 0;

        for ( int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if ( puz.getTiles()[i][j] == 9)
                    continue;
                if ( puz.getTiles()[i][j] != GOAL_STATE.getTiles()[i][j])
                    misplaced++;
            }
        }

        return misplaced + puz.getMovesSoFar();
    }
}

