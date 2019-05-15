package project;

import gridworld.actor.LevelPellet;
import gridworld.actor.Pacman;
import gridworld.actor.Pellet;
import gridworld.actor.Wall;
import gridworld.grid.BoundedGrid;
import gridworld.grid.Location;
import gridworld.world.PacmanWorld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Main
{

    public static final int ROW = 27;

    public static final int COL = 24;



    public static final BoundedGrid grid = new BoundedGrid( ROW, COL );


    public static int currentLevel;




    public static void main( String[] args )
    {
        PacmanWorld world = new PacmanWorld( grid );

        initGrid( grid );
        LevelPellet lp = new LevelPellet("level1");

        Pacman p = new Pacman();

        p.putSelfInGrid( grid, new Location(4,12) );

        world.show();



    }


    private static void initGrid( BoundedGrid grid )
    {

        Main m = new Main();
        try
        {

            InputStream in = m.getClass().getResourceAsStream("/level0.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;

            for ( int i = 0; i < Main.ROW - 1; i++ )
            {
                do
                {
                    //find next good line
                    line = br.readLine();
                    line = line.replaceAll( "[^a-z]",
                                    "" );

                } while ( line.length() <= 0 );
                for ( int j = 0; j < Main.COL ; j++ )

                {
                    if ( line.charAt( j ) == 'x' )
                    {
                        Wall w = new Wall();
                        w.putSelfInGrid( grid, new Location( i , j ) );

                    }
                    else if ( line.charAt( j ) == 'o' )
                    {
                        Pellet p = new Pellet();
                        p.putSelfInGrid( grid, new Location( i , j ) );
                    }
                }
            }
        }
        catch ( IOException e )
        {
            e.printStackTrace();
            System.err.println( "Brad says \"shet2\"" );
            System.exit( -1 );
        }

        //Left pellet
        LevelPellet level1 = new LevelPellet( "level1" );
        level1.putSelfInGrid( grid, new Location( 20, 4 ) );

        //Middle pellet
        LevelPellet level2 = new LevelPellet( "level2" );
        level2.putSelfInGrid( grid, new Location( 20, 12 ) );

        //Right pellet
        LevelPellet level3 = new LevelPellet( "level3" );
        level3.putSelfInGrid( grid, new Location( 20, 19 ) );


        Pacman.drawPacmanName();



    }



}
