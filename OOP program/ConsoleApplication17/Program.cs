using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication17
{
    class Program
    {
        static void Main(string[] args)
        {
            Ball ball_1 = new Ball(10, 0);
            Ball ball_2 = new Ball(15, 0);
            Ball ball_3 = new Ball(20, 0);
            Ball ball_4 = new Ball(25, 4);
            Ball ball_5 = new Ball(30, 0);
            Ball ball_6 = new Ball(35, 4);
            Ball ball_7 = new Ball(40, 4);

            ball_1.Pop();
            ball_1.Throw();
            ball_2.Pop();
            for (int i = 0; i < 10; i++)
            {
                ball_2.Throw();
            }
            ball_3.Throw();
            ball_4.Throw();
            for (int i = 0; i < 10; i++)
            {
                ball_5.Throw();
            }
            for (int i = 0; i < 10; i++)
            {
                ball_6.Throw();
            }
            ball_7.Throw();
            ball_7.Pop();
            Console.WriteLine(ball_1.GetThrowCount());
            Console.WriteLine(ball_2.GetThrowCount());
            Console.WriteLine(ball_3.GetThrowCount());
            Console.WriteLine(ball_4.GetThrowCount());
            Console.WriteLine(ball_5.GetThrowCount());
            Console.WriteLine(ball_6.GetThrowCount());
            Console.WriteLine(ball_7.GetThrowCount());

            ball_1.Score = 40;
            int currentScore = ball_1.Score;
            Console.WriteLine(currentScore);

            Console.ReadKey();
        }
    }
}
