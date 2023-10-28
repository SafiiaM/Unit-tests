"""
Модуль для сравнения средних арифметических значений двух списков чисел
"""
from pytest import mark, raises
from program import Program


class TestProgram:
    """
    Класс содержит методы сравнения средних арифметических значений двух списков чисел
    """
    @mark.parametrize("list1, list2, avg1, avg2", [([1, 2, 3], [2, 4, 6], 2, 4),
                                                   ([3, 3, 3], [12, 1, 2], 3, 5),
                                                   ([2.2, 3.5, 3.3], [1.4, 2.6, 2.3],
                                                    3.0, 2.1)])
    def test_avg_lists_equality(self, list1, list2, avg1, avg2):
        """
        Тест подсчёта средних арифметических значений двух списков
        :param list1: [nums]
        :param list2: [nums]
        :param avg1: avg(list1)
        :param avg2: avg(list2)
        """
        res1, res2 = Program.avgs(list1, list2)
        assert res1 == avg1
        assert res2 == avg2

    @mark.parametrize("list1, list2, error", [([1, 2, 3], ["d", "q"], TypeError),
                                              (["d", "q"], [12, 1, 2], TypeError)])
    def test_avg_lists_with_error(self, list1, list2, error):
        """
        Тест на поиск значений с ошибкой типа
        :param list1: [nums]
        :param list2: [nums]
        :param error: ErrorType
        """
        with raises(error):
            Program.avgs(list1, list2)

    def test_avr_lists_clear_list(self):
        """
        Тест на поиск пустого списка
        """
        with raises(ValueError):
            Program.avgs([], [1, 2])

    @mark.parametrize("arg1, arg2, compare", [(4, 2, "Первый список имеет большее среднее значение"),
                                              (1, 3, "Второй список имеет большее среднее значение"),
                                              (6, 6, "Средние значения равны")])
    def test_compare_avg_valid(self, arg1, arg2, compare):
        """
        Тест на сравнение средних значений
        :param arg1: num
        :param arg2: num
        :param compare: Тезультирующий текст
        """
        res = Program.comparison(arg1, arg2)
        assert res == compare

    def test_compare_avg_not_valid(self):
        """
        Тест на сравнение средних невалидных значений
        """
        with raises(TypeError):
            Program.comparison("123", 15)

    @mark.parametrize("list1, list2", [([2, 4], [1, 1]), ([1, 3], [6, 5]), ([6, 6], [5, 7])])
    def test_program_success(self, list1, list2):
        """
        Интеграционный тест на успешность сравнения списков класса Program
        :param list1: [num]
        :param list2: [num]
        """
        Program.compare(list1, list2)

    def test_program_with_error(self):
        """
        Интеграционный тест сравнения списков класса Program с ошибкой неверного типа данных
        """
        with raises(TypeError):
            Program.compare(["dsd", "qwe"], [12, 23])

    def test_program_clear_list(self):
        """
        Интеграционный тест сравнения списков класса Program с ошибкой при отправке пустого списка
        :return:
        """
        with raises(ValueError):
            Program.compare([], [12, 23])
