using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication17
{
    class Ball
    {
        private int score;
        public int radius;
        public int throwCount;
        public bool poped;

        public Ball(int radius, int throwCount)
        {
            this.radius = radius;
            this.throwCount = throwCount;
        }
        public void Pop()
        {
            radius = 0;
            poped = true;
        }
        public void Throw()
        {
            if (!poped) { throwCount++; }
        }
        public int GetThrowCount()
        {
            return throwCount;
        }
        public int Score1 { get; set; }
        public int Score
        {
            get
            {
                return score;
            }
            set
            {
                score = value;
            }
        }
    }
}
