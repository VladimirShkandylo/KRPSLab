using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication17
{
    public class Colour
    {
        public short red;
        public short green;
        public short blue;
        public short alpha;

        public Colour(short red, short green, short blue, short alpha)
        {
            this.red = red;
            this.green = green;
            this.blue = blue;
            this.alpha = alpha;
        }
        public Colour(short red, short green, short blue)
        {
            this.red = red;
            this.green = green;
            this.blue = blue;
            this.alpha = 255;
        }
        public void SetColourValues(short red, short green, short blue, short alpha)
        {
            this.red = red;
            this.green = green;
            this.blue = blue;
            this.alpha = alpha;
        }
        public short GetColourValues()
        {
            return red;
            return green;
            return blue;
            return alpha;
        }
        public short GetGrayScaleColourValues()
        {
            return red = 128;
            return green = 128;
            return blue = 128;
            return alpha = 128;
        }
    }
}
