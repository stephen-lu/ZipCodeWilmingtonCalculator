import unittest
import math
from calculator import Calculator


class TestStringMethods(unittest.TestCase):

    def test_add(self):
        c = Calculator()
        self.assertEqual(c.add(3, 3), 6)

    def test_add2(self):
        c = Calculator()
        self.assertEqual(c.add(12, -10), 2)

    def test_add3(self):
        c = Calculator()
        self.assertEqual(c.add(5, 8), 13)

    # ---------- sub ----------
    def test_sub_positive(self):
        c = Calculator()
        self.assertEqual(c.sub(10, 5), 5)

    def test_sub_negative(self):
        c = Calculator()
        self.assertEqual(c.sub(-3, -7), 4)

    def test_sub_mixed(self):
        c = Calculator()
        self.assertEqual(c.sub(5, -2), 7)

    # ---------- div ----------
    def test_div_normal(self):
        c = Calculator()
        self.assertEqual(c.div(10, 2), 5)

    def test_div_float(self):
        c = Calculator()
        self.assertAlmostEqual(c.div(7, 3), 2.3333, places=4)

    def test_div_by_zero(self):
        c = Calculator()
        with self.assertRaises(ZeroDivisionError):
            c.div(5, 0)

    # ---------- mult ----------
    def test_mult_positive(self):
        c = Calculator()
        self.assertEqual(c.mult(3, 4), 12)

    def test_mult_negative(self):
        c = Calculator()
        self.assertEqual(c.mult(-2, 5), -10)

    def test_mult_zero(self):
        c = Calculator()
        self.assertEqual(c.mult(100, 0), 0)

    # ---------- square ----------
    def test_square_positive(self):
        c = Calculator()
        self.assertEqual(c.square(5), 25)

    def test_square_negative(self):
        c = Calculator()
        self.assertEqual(c.square(-3), 9)

    def test_square_zero(self):
        c = Calculator()
        self.assertEqual(c.square(0), 0)

    # ---------- root ----------
    def test_root_perfect_square(self):
        c = Calculator()
        self.assertEqual(c.root(16), 4)

    def test_root_decimal(self):
        c = Calculator()
        self.assertAlmostEqual(c.root(2), math.sqrt(2))

    def test_root_negative(self):
        c = Calculator()
        self.assertEqual(c.root(-4), "Err")

    # ---------- exp ----------
    def test_exp_positive(self):
        c = Calculator()
        self.assertEqual(c.exp(2, 3), 8)

    def test_exp_zero(self):
        c = Calculator()
        self.assertEqual(c.exp(5, 0), 1)

    def test_exp_negative(self):
        c = Calculator()
        self.assertEqual(c.exp(2, -2), 0.25)

    # ---------- exp ----------
    def test_factorial_positive(self):
        c = Calculator()
        self.assertEqual(c.factorial(5), 120)

    def test_factorial_zero(self):
        c = Calculator()
        self.assertEqual(c.factorial(0), 1)

    def test_factprial_negative(self):
        c = Calculator()
        self.assertEqual(c.factorial(-2), "Err")

    # ---------- inverse ----------
    def test_inverse_positive(self):
        c = Calculator()
        self.assertEqual(c.inverse(4), 0.25)

    def test_inverse_negative(self):
        c = Calculator()
        self.assertEqual(c.inverse(-2), -0.5)
        
    def test_inverse_zero(self):
        c = Calculator()
        with self.assertRaises(ZeroDivisionError):
            c.inverse(0)

    # ---------- invert ----------
    def test_invert_positive(self):
        c = Calculator()
        self.assertEqual(c.invert(10), -10)

    def test_invert_negative(self):
        c = Calculator()
        self.assertEqual(c.invert(-5), 5)

    def test_invert_zero(self):
        c = Calculator()
        self.assertEqual(c.invert(0), 0)

    # ---------- sin ----------
    def test_sin_zero(self):
        c = Calculator()
        self.assertEqual(c.sin(0), 0)

    def test_sin_pi_over_2(self):
        c = Calculator()
        self.assertAlmostEqual(c.sin(math.pi / 2), 1.0)
        
    def test_sin_negative(self):
        c = Calculator()
        self.assertAlmostEqual(c.sin(-math.pi / 2), -1.0)

    # ---------- cos ----------
    def test_cos_zero(self):
        c = Calculator()
        self.assertEqual(c.cos(0), 1)

    def test_cos_pi(self):
        c = Calculator()
        self.assertAlmostEqual(c.cos(math.pi), -1.0)

    def test_cos_pi_over_2(self):
        c = Calculator()
        self.assertAlmostEqual(c.cos(math.pi / 2), 0.0, places=5)

    # ---------- tan ----------
    def test_tan_zero(self):
        c = Calculator()
        self.assertEqual(c.tan(0), 0)

    def test_tan_pi_over_4(self):
        c = Calculator()
        self.assertAlmostEqual(c.tan(math.pi / 4), 1.0)

    def test_tan_negative(self):
        c = Calculator()
        self.assertAlmostEqual(c.tan(-math.pi / 4), -1.0)

    # ---------- asin ----------
    def test_asin_zero(self):
        c = Calculator()
        self.assertEqual(c.asin(0), 0)

    def test_asin_one(self):
        c = Calculator()
        self.assertAlmostEqual(c.asin(1), math.pi / 2)

    def test_asin_out_of_domain(self):
        c = Calculator()
        with self.assertRaises(ValueError):
            c.asin(2)

    # ---------- acos ----------
    def test_acos_one(self):
        c = Calculator()
        self.assertEqual(c.acos(1), 0)

    def test_acos_zero(self):
        c = Calculator()
        self.assertAlmostEqual(c.acos(0), math.pi / 2)

    def test_acos_out_of_domain(self):
        c = Calculator()
        with self.assertRaises(ValueError):
            c.acos(-2)

    # ---------- atan ----------
    def test_atan_zero(self):
        c = Calculator()
        self.assertEqual(c.atan(0), 0)

    def test_atan_one(self):
        c = Calculator()
        self.assertAlmostEqual(c.atan(1), math.pi / 4)

    def test_atan_negative(self):
        c = Calculator()
        self.assertAlmostEqual(c.atan(-1), -math.pi / 4)

    # ---------- log ----------
    def test_log_10(self):
        c = Calculator()
        self.assertEqual(c.log(10), 1)

    def test_log_100(self):
        c = Calculator()
        self.assertEqual(c.log(100), 2)

    def test_log_invalid(self):
        c = Calculator()
        with self.assertRaises(ValueError):
            c.log(-10)

    # ---------- logBase ----------
    def test_logBase_8_base_2(self):
        c = Calculator()
        self.assertEqual(c.logBase(8, 2), 3)

    def test_logBase_27_base_3(self):
        c = Calculator()
        self.assertEqual(c.logBase(27, 3), 3)

    def test_logBase_invalid(self):
        c = Calculator()
        with self.assertRaises(ValueError):
            c.logBase(-1, 2)

    # ---------- ln ----------
    def test_ln_e(self):
        c = Calculator()
        self.assertEqual(c.ln(math.e), 1)
        
    def test_ln_1(self):
        c = Calculator()
        self.assertEqual(c.ln(1), 0)

    def test_ln_invalid(self):
        c = Calculator()
        with self.assertRaises(ValueError):
            c.ln(0)

    # ---------- inLog ----------
    def test_inLog_2(self):
        c = Calculator()
        self.assertEqual(c.inLog(2), 100)

    def test_inLog_0(self):
        c = Calculator()
        self.assertEqual(c.inLog(0), 1)

    def test_inLog_negative(self):
        c = Calculator()
        self.assertAlmostEqual(c.inLog(-1), 0.1)

    # ---------- inLogBase ----------
    def test_inLogBase_2_base_3(self):
        c = Calculator()
        self.assertEqual(c.inLogBase(2, 3), 9)
        
    def test_inLogBase_0_base_5(self):
        c = Calculator()
        self.assertEqual(c.inLogBase(0, 5), 1)

    def test_inLogBase_negative_exp(self):
        c = Calculator()
        self.assertEqual(c.inLogBase(-1, 2), 0.5)

    # ---------- inLn ----------
    def test_inLn_1(self):
        c = Calculator()
        self.assertEqual(c.inLn(1), math.e)

    def test_inLn_0(self):
        c = Calculator()
        self.assertEqual(c.inLn(0), 1)
        
    def test_inLn_negative(self):
        c = Calculator()
        self.assertAlmostEqual(c.inLn(-1), 1 / math.e)

    


if __name__ == '__main__':
    unittest.main()
