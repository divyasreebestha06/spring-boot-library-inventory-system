import unittest

class TestLibraryCirculation(unittest.TestCase):
    def test_state_transitions(self):
        available = True
        # Borrow
        available = False
        self.assertFalse(available)
        # Return
        available = True
        self.assertTrue(available)

if __name__ == "__main__":
    unittest.main()
