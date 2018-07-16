def matrix_mul (first_arr, second_arr)
    return 0
end

def matrix_add (first_arr, second_arr)
    add_arr = Array.new[first_arr.length][first_arr[0].length]
    if first_arr.length == second_arr.length && first_arr[0].length == second_arr[0].length #checks if each row and col is same length
        first_arr.length.times { |num1|
            second_arr.length.times { |num2|
                num1 -= 1;
                num2 -= 1;
                add_arr[num1][num2] = first_arr[num1][num2] + second_arr[num1][num2]
            }
        }
    end
end

#first_matrix = get_matrix
#second_matrix = get_matrix
first_matrix = [[824,-65,-814,-741,-979,-764], 
                [216,663,880,916,617,-535],
                [597,-245,79,747,477,-535],
                [-906,-905,-266,-8,765,448],
                [-348,470,-608,-686,702,61],
                [-49,-433,966,902,-942,712]]
second_matrix = [[961,-892,-564,-826,251,-414],
                 [-44,-214,235,-781,421,-340],
                 [881,444,360,932,700,725],
                 [-750,-637,-915,192,617,41],
                 [509,-167,127,628,51,837],
                 [-28,57,-13,-436,-720,222],]
multiply = matrix_mul(first_matrix, second_matrix)
add = matrix_add(first_matrix, second_matrix)
puts add

