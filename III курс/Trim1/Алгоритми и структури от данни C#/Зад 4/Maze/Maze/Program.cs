using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Maze
{
    class Program
    {
        private class Tile
        {
            public int Row { get; set; }
            public int Col { get; set; }
            public Tile(int r, int c)
            {
                Row = r; Col = c;
            }
        }

        private class ExitPath
        {
            public List<Tile> path;
            public ExitPath()
            {
                path = new List<Tile>();
            }
        }

        private static List<ExitPath> paths;
        private static int counter = 0;

        private static int[,] TILES;
        private static Tile spawn;

        private static bool isPathFound;

        static void Main(string[] args)
        {
            Console.OutputEncoding = Encoding.UTF8;
            /*
            // 1 = път; 0 = стена; 2 = споун

            TILES = new int[10, 10];
            spawn = new Tile(2, 5);
            TILES[spawn.Row, spawn.Col] = 2; //spawn

            //пътеки
            TILES[3,0] = 1;
            TILES[3,1] = 1;
            TILES[3,2] = 1;
            TILES[3,3] = 1;
            TILES[3,4] = 1;
            TILES[2,4] = 1;
            TILES[1,5] = 1;
            TILES[2,6] = 1;
            TILES[2,7] = 1;
            TILES[3,6] = 1;
            TILES[4,6] = 1;
            TILES[5,3] = 1;
            TILES[5,4] = 1;
            TILES[5,5] = 1;
            TILES[5,6] = 1;
            TILES[5,8] = 1;
            TILES[5,9] = 1;
            TILES[6,6] = 1;
            TILES[6,7] = 1;
            TILES[6,8] = 1;
            TILES[6,9] = 1;
            TILES[7,8] = 1;
            TILES[7,9] = 1;
            TILES[8,8] = 1;
            TILES[9,7] = 1;
            TILES[9,8] = 1;
            TILES[4, 2] = 1;
            TILES[5, 2] = 1;

            SolveMaze();

            Console.WriteLine("\n\n\nRandom:");*/
            Random r = new Random();
            TILES = new int[r.Next(10, 25), r.Next(10, 25)]; //случаен размер
            spawn = new Tile(r.Next(1, TILES.GetLength(0) - 1), r.Next(1, TILES.GetLength(1) - 1)); //случаен споун, който да не е в краищата

            for (int i = 0; i < TILES.GetLength(0); i++)
            {
                for (int j = 0; j < TILES.GetLength(1); j++)
                {
                    TILES[i, j] = r.Next(0, 2); //случаен терен (0 или 1)
                }
            }
            TILES[spawn.Row, spawn.Col] = 2;
            SolveMaze();

            Console.ReadKey();
        }

        private static void SolveMaze()
        {
            paths = new List<ExitPath>();
            FindPath(new Tile(spawn.Row, spawn.Col), TILES, new List<Tile>(), new Tile(spawn.Row, spawn.Col));
            Print();
            paths.Clear();
            paths = null;
            isPathFound = false;
            counter = 0;
        }

        private static void FindPath(Tile tile, int[,] tiles, List<Tile> path, Tile prevTile)
        {
            if (isPathFound) return;

            ExitPath tempPath = new ExitPath();

            tempPath.path = path.ToList();
            tempPath.path.Add(tile);

            paths.Add(tempPath);
            counter++;

            int[,] tempTiles = tiles.Clone() as int[,];
            tempTiles[prevTile.Row, prevTile.Col] = 0; // за да не се връща назад

            if (tile.Row == 0 || tile.Row == TILES.GetLength(0) - 1 || tile.Col == 0 || tile.Col == TILES.GetLength(1) - 1)  //в края сме => изход
            {
                isPathFound = true;
                return;
            }

            //ако няма път на никъде
            /*if(tempTiles[tile.Row - 1, tile.Col] == 0 && tempTiles[tile.Row + 1, tile.Col] == 0 && tempTiles[tile.Row, tile.Col - 1] == 0 && tempTiles[tile.Row, tile.Col + 1] == 0)
            {
                //tempTiles[tile.Row, tile.Col] = 0;
                //paths[counter - 1].path.Remove(prevTile); //с нищо не помага, понеже трябва да се изчисти листа до преди няколко функции, когато е тръгнало в това разклонение
                //paths[counter - 1].path.Remove(tile);
            }*/

            if (tempTiles[tile.Row, tile.Col + 1] == 1) FindPath(new Tile(tile.Row, tile.Col + 1), tempTiles, tempPath.path.ToList(), tile); //ако в дясно има път
            if (tempTiles[tile.Row, tile.Col - 1] == 1) FindPath(new Tile(tile.Row, tile.Col - 1), tempTiles, tempPath.path.ToList(), tile); //ако в ляво има път
            if (tempTiles[tile.Row - 1, tile.Col] == 1) FindPath(new Tile(tile.Row - 1, tile.Col), tempTiles, tempPath.path.ToList(), tile); //ако горе има път
            if (tempTiles[tile.Row + 1, tile.Col] == 1) FindPath(new Tile(tile.Row + 1, tile.Col), tempTiles, tempPath.path.ToList(), tile); //ако долу има път
        } // край на FindPath()

        private static void Print()
        {
            var originalColor = Console.ForegroundColor;

            Console.WriteLine("Maze:");
            for (int i = 0; i < TILES.GetLength(0); i++)
            {
                for (int j = 0; j < TILES.GetLength(1); j++)
                {
                    Console.Write(TILES[i, j] + " ");
                }
                Console.WriteLine();
            }

            if (isPathFound)
            {
                int[,] path = TILES.Clone() as int[,];

                List<Tile> exitPath = paths[counter - 1].path.ToList();

                for (int k = 0; k < exitPath.Count; k++)
                {
                    Console.ForegroundColor = originalColor;
                    Console.WriteLine("Ход " + k + ":");
                    path[exitPath[k].Row, exitPath[k].Col] = 2;
                    if (k != 0) path[exitPath[k - 1].Row, exitPath[k - 1].Col] = TILES[exitPath[k - 1].Row, exitPath[k - 1].Col];

                    for (int i = 0; i < path.GetLength(0); i++)
                    {
                        for (int j = 0; j < path.GetLength(1); j++)
                        {
                            if (i == spawn.Row && j == spawn.Col)
                            {
                                Console.ForegroundColor = ConsoleColor.Blue;
                                Console.Write("S ");
                            }
                            else if (path[i, j] == 0)
                            {
                                Console.ForegroundColor = ConsoleColor.Magenta;
                                Console.Write("# ");
                            }
                            else if (path[i, j] == 1)
                            {
                                Console.ForegroundColor = ConsoleColor.White;
                                Console.Write(". ");
                            }
                            else if (path[i, j] == 2)
                            {
                                Console.ForegroundColor = ConsoleColor.Yellow;
                                Console.Write("P ");
                            }
                        }
                        Console.WriteLine();
                    }
                    Console.WriteLine();
                }

                Console.ForegroundColor = originalColor;
                Console.WriteLine("Намерен е изход на [" + exitPath[exitPath.Count - 1].Row + "][" + exitPath[exitPath.Count - 1].Col + "]");
                Console.WriteLine("\nЦял път:");



                for (int i = 0; i < exitPath.Count; i++) path[exitPath[i].Row, exitPath[i].Col] = 2;

                for (int i = 0; i < path.GetLength(0); i++)
                {
                    for (int j = 0; j < path.GetLength(1); j++)
                    {
                        if (i == spawn.Row && j == spawn.Col)
                        {
                            Console.ForegroundColor = ConsoleColor.Blue;
                            Console.Write("S ");
                        }
                        else if (path[i, j] == 0)
                        {
                            Console.ForegroundColor = ConsoleColor.Magenta;
                            Console.Write("# ");
                        }
                        else if (path[i, j] == 1)
                        {
                            Console.ForegroundColor = ConsoleColor.White;
                            Console.Write(". ");
                        }
                        else if (path[i, j] == 2)
                        {
                            Console.ForegroundColor = ConsoleColor.Yellow;
                            Console.Write("P ");
                        }
                    }
                    Console.WriteLine();
                }
                Console.WriteLine();
            }
            else
            {
                Console.ForegroundColor = originalColor;
                Console.WriteLine("Няма изход!");
                for (int i = 0; i < TILES.GetLength(0); i++)
                {
                    for (int j = 0; j < TILES.GetLength(1); j++)
                    {
                        if (i == spawn.Row && j == spawn.Col)
                        {
                            Console.ForegroundColor = ConsoleColor.Blue;
                            Console.Write("S ");
                        }
                        else if (TILES[i, j] == 0)
                        {
                            Console.ForegroundColor = ConsoleColor.Magenta;
                            Console.Write("# ");
                        }
                        else if (TILES[i, j] == 1)
                        {
                            Console.ForegroundColor = ConsoleColor.White;
                            Console.Write(". ");
                        }
                    }
                    Console.WriteLine();
                }
                Console.WriteLine();
            }
            Console.ForegroundColor = originalColor;
        }

    }
}
