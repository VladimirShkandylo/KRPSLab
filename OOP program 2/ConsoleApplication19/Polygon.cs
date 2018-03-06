using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication19
{
    class Polygon
    {
        public int NumberOfSides { get; set; }
        public string name;

        public Polygon()
        {
            NumberOfSides = 0;
        }
        public Polygon(int numberOfSides)
        {
            NumberOfSides = numberOfSides;
            if (numberOfSides == 3)
            {
                name = "triangle";
                Console.WriteLine(name);
            }
        }
    }
}
