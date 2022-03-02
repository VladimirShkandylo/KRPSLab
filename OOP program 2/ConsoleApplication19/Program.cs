using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication19
{
    class Programm
    {
        static void Main()
        {
            int x;
            Console.WriteLine("Enter number of sides");
            x = Convert.ToInt32(Console.ReadLine());
            Polygon polygon = new Polygon(x);
            Polygon polygon1 = new Square(6);
            Square square = new Square(4);
            if (polygon1 is Square)
            {
                Square square1 = (Square)polygon;

                Square square2 = polygon as Square;
            }

            // Creating array that stores all derived classes of a parent class 
            Polygon[] lotsOfPolygons = new Polygon[5];
            lotsOfPolygons[2] = new Square(2.1f);
            lotsOfPolygons[3] = new Polygon(3);

            Console.ReadKey();
        }
    }
}
