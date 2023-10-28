class Program:
    @staticmethod
    def compare(list1, list2):
        """
        Сравнение двух списков
        :param list1: [nums]
        :param list2: [nums]
        """
        print(Program.comparison(*Program.avgs(list1, list2)))

    @staticmethod
    def avgs(list1, list2):
        """
        Среднее арифметическое двух списков
        :param list1: list(nums)
        :param list2: list(nums)
        :return: [num, num]
        """
        if len(list1) == 0 or len(list2) == 0:
            raise ValueError
        res = []
        for arg in [list1, list2]:
            sum = 0
            for i in arg:
                if not (isinstance(i, int) or isinstance(i, float)):
                    raise TypeError
                sum += i
            res.append(sum / len(arg))
        return res

    @staticmethod
    def comparison(avg1, avg2):
        """
        Сравнение двух чисел
        :param avg1: num
        :param avg2: num
        :return: str
        """
        for i in [avg1, avg2]:
            if not (isinstance(i, int) or isinstance(i, float)):
                raise TypeError
        if avg1 > avg2:
            return "Первый список имеет большее среднее значение"
        elif avg2 > avg1:
            return "Второй список имеет большее среднее значение"
        else:
            return "Средние значения равны"