namespace WindowsFormsApplication2
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.lblQuestion = new System.Windows.Forms.Label();
            this.Answer1 = new System.Windows.Forms.Button();
            this.Answer2 = new System.Windows.Forms.Button();
            this.Answer3 = new System.Windows.Forms.Button();
            this.Answer4 = new System.Windows.Forms.Button();
            this.lblName = new System.Windows.Forms.Label();
            this.txtName = new System.Windows.Forms.TextBox();
            this.lblScore = new System.Windows.Forms.Label();
            this.StartButton = new System.Windows.Forms.Button();
            this.FinishButton = new System.Windows.Forms.Button();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // lblQuestion
            // 
            this.lblQuestion.AutoSize = true;
            this.lblQuestion.Location = new System.Drawing.Point(30, 25);
            this.lblQuestion.Name = "lblQuestion";
            this.lblQuestion.Size = new System.Drawing.Size(383, 13);
            this.lblQuestion.TabIndex = 2;
            this.lblQuestion.Text = "Q1 - Which of the following is correct about variable naming conventions in C#?";
            // 
            // Answer1
            // 
            this.Answer1.Location = new System.Drawing.Point(33, 56);
            this.Answer1.Name = "Answer1";
            this.Answer1.Size = new System.Drawing.Size(169, 55);
            this.Answer1.TabIndex = 7;
            this.Answer1.Text = "A.\tA name must begin with a letter that could be followed by a sequence of letter" +
    "s, digits (0 - 9) or underscore.";
            this.Answer1.UseVisualStyleBackColor = true;
            this.Answer1.Click += new System.EventHandler(this.Answer1_Click);
            // 
            // Answer2
            // 
            this.Answer2.Location = new System.Drawing.Point(244, 56);
            this.Answer2.Name = "Answer2";
            this.Answer2.Size = new System.Drawing.Size(169, 55);
            this.Answer2.TabIndex = 8;
            this.Answer2.Text = "B.\tThe first character in an identifier cannot be a digit.";
            this.Answer2.UseVisualStyleBackColor = true;
            this.Answer2.Click += new System.EventHandler(this.Answer2_Click);
            // 
            // Answer3
            // 
            this.Answer3.Location = new System.Drawing.Point(33, 130);
            this.Answer3.Name = "Answer3";
            this.Answer3.Size = new System.Drawing.Size(169, 23);
            this.Answer3.TabIndex = 9;
            this.Answer3.Text = "C.\tBoth of the above.";
            this.Answer3.UseVisualStyleBackColor = true;
            this.Answer3.Click += new System.EventHandler(this.Answer3_Click);
            // 
            // Answer4
            // 
            this.Answer4.Location = new System.Drawing.Point(244, 130);
            this.Answer4.Name = "Answer4";
            this.Answer4.Size = new System.Drawing.Size(169, 23);
            this.Answer4.TabIndex = 10;
            this.Answer4.Text = "D.\tNone of the above.";
            this.Answer4.UseVisualStyleBackColor = true;
            this.Answer4.Click += new System.EventHandler(this.Answer4_Click);
            // 
            // lblName
            // 
            this.lblName.AutoSize = true;
            this.lblName.Location = new System.Drawing.Point(143, 16);
            this.lblName.Name = "lblName";
            this.lblName.Size = new System.Drawing.Size(87, 13);
            this.lblName.TabIndex = 11;
            this.lblName.Text = "Enter your name:";
            // 
            // txtName
            // 
            this.txtName.Location = new System.Drawing.Point(236, 13);
            this.txtName.Name = "txtName";
            this.txtName.Size = new System.Drawing.Size(100, 20);
            this.txtName.TabIndex = 12;
            this.txtName.TextChanged += new System.EventHandler(this.txtName_TextChanged);
            // 
            // lblScore
            // 
            this.lblScore.AutoSize = true;
            this.lblScore.Location = new System.Drawing.Point(262, 269);
            this.lblScore.Name = "lblScore";
            this.lblScore.Size = new System.Drawing.Size(71, 13);
            this.lblScore.TabIndex = 13;
            this.lblScore.Text = "Your score is:";
            this.lblScore.Visible = false;
            // 
            // StartButton
            // 
            this.StartButton.Location = new System.Drawing.Point(165, 48);
            this.StartButton.Name = "StartButton";
            this.StartButton.Size = new System.Drawing.Size(137, 23);
            this.StartButton.TabIndex = 14;
            this.StartButton.Text = "Start Quiz";
            this.StartButton.UseVisualStyleBackColor = true;
            this.StartButton.Visible = false;
            this.StartButton.Click += new System.EventHandler(this.StartButton_Click);
            // 
            // FinishButton
            // 
            this.FinishButton.Location = new System.Drawing.Point(111, 264);
            this.FinishButton.Name = "FinishButton";
            this.FinishButton.Size = new System.Drawing.Size(112, 23);
            this.FinishButton.TabIndex = 15;
            this.FinishButton.Text = "Calculate your score";
            this.FinishButton.UseVisualStyleBackColor = true;
            this.FinishButton.Visible = false;
            this.FinishButton.Click += new System.EventHandler(this.FinishButton_Click);
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.Answer1);
            this.groupBox1.Controls.Add(this.Answer3);
            this.groupBox1.Controls.Add(this.Answer4);
            this.groupBox1.Controls.Add(this.Answer2);
            this.groupBox1.Controls.Add(this.lblQuestion);
            this.groupBox1.Location = new System.Drawing.Point(21, 77);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(445, 181);
            this.groupBox1.TabIndex = 16;
            this.groupBox1.TabStop = false;
            this.groupBox1.Visible = false;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(496, 302);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.FinishButton);
            this.Controls.Add(this.StartButton);
            this.Controls.Add(this.lblScore);
            this.Controls.Add(this.txtName);
            this.Controls.Add(this.lblName);
            this.Name = "Form1";
            this.Text = "Form1";
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Label lblQuestion;
        private System.Windows.Forms.Button Answer1;
        private System.Windows.Forms.Button Answer2;
        private System.Windows.Forms.Button Answer3;
        private System.Windows.Forms.Button Answer4;
        private System.Windows.Forms.Label lblName;
        private System.Windows.Forms.TextBox txtName;
        private System.Windows.Forms.Label lblScore;
        private System.Windows.Forms.Button StartButton;
        private System.Windows.Forms.Button FinishButton;
        private System.Windows.Forms.GroupBox groupBox1;
    }
}

