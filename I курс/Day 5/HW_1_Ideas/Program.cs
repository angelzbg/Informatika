using System;

namespace HW_1_Ideas
{
    class Program
    {
        static bool IsEGNValid (string eng)
        {
            int[] numbers = new int[10];
            
            //1. Check length...

            //2. Convert to an array of numbers
            for (int i = 0; i < 10; i++)
            {
                if (Char.IsDigit(eng[i]))
                {
                    numbers[i] = (int)(eng[i] - '0');
                }
                else return false;
            }

            //3. Check date...

            //4. Checksum
            int[] coef = { 2, 4, 8, 5, 10, 9, 7, 3, 6 };
            int sum = 0;
            for (int i = 0; i < 9; i++)
            {
                sum = sum + numbers[i] * coef[i];
            }
            int checksum = sum % 11;

            if (checksum == 10) checksum = 0;

            return numbers[9] == checksum;
        }

        static void Main(string[] args)
        {
        }
    }
}
