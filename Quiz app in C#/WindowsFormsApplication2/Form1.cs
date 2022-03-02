using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApplication2
{
    public partial class Form1 : Form
    {
        int q = 1;
        public int x = 0;
        public Form1()
        {
            InitializeComponent();
        }

        private void StartButton_Click(object sender, EventArgs e)
        {
            groupBox1.Visible = true;
            StartButton.Visible = false;
        }

        public void Answer3_Click(object sender, EventArgs e)
        {
            if (q == 1) { x++; }
            Next_Question();
        }

        public void Answer2_Click(object sender, EventArgs e)
        {
            Next_Question();
        }

        public void Answer1_Click(object sender, EventArgs e)
        {
            if (q == 3) { x++; }
            if (q == 4) { x++; }
            Next_Question();
        }

        public void Answer4_Click(object sender, EventArgs e)
        {
            if (q == 2) { x++; }
            if (q == 5) { x++; }
            Next_Question();
        }

        public void Next_Question()
        {
            q++;
            if (q == 2)
            {
                lblQuestion.Text = "Q 2 - Which of the following converts a type to a integer type in C#?";
                Answer1.Text = "A.	ToDecimal()";
                Answer2.Text = "B.	ToDouble()";
                Answer3.Text = "C.	ToInt16()";
                Answer4.Text = "D.	ToInt32()";
            }
            else if (q == 3)
            {
                lblQuestion.Text = "Q 3 - Which of the following converts a type to a Boolean value, where possible in C#?";
                Answer1.Text = "A.	ToBoolean()";
                Answer2.Text = "B.	ToSingle()";
                Answer3.Text = "C.	ToChar()";
                Answer4.Text = "D.	ToDateTime()";
            }
            else if (q == 4)
            {
                lblQuestion.Text = "Q 4 - Which of the following converts a floating point or integer type to a decimal type in C#?";
                Answer1.Text = "A.	ToDecimal()";
                Answer2.Text = "B.	ToDouble()";
                Answer3.Text = "C.	ToInt16()";
                Answer4.Text = "D.	ToInt32()";
            }
            else if (q == 5)
            {
                lblQuestion.Text = "Q 5 - Which of the following is correct about value type variables in C#?";
                Answer1.Text = "A.	The value types directly contain data.";
                Answer2.Text = "B.	Int, char, and float, which stores numbers, alphabets, and floating point numbers, respectively are value types.";
                Answer3.Text = "C.	When you declare an int type, the system allocates memory to store the value.";
                Answer4.Text = "D.	All of the above.";
            }
            else if (q == 6)
            {
                FinishButton.Visible = true;
                Answer1.Visible = false;
                Answer2.Visible = false;
                Answer3.Visible = false;
                Answer4.Visible = false;
                lblQuestion.Visible = false;
            }
        }

        private void txtName_TextChanged(object sender, EventArgs e)
        {
            StartButton.Visible = true;
        }

        private void FinishButton_Click(object sender, EventArgs e)
        {
            lblScore.Visible = true;
            lblScore.Text = "Your score is: " + x.ToString();
        }
    }
}

