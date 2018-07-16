def prime_factor number
    arr = []
    finished = false
    factor = 2
    until finished == true
        until number % factor != 0
            arr.push(factor)
            number /= factor;
        end
        factor +=1;
        finished = true if number == 1
    end
    arr
end


puts prime_factor(8856433488048012)
puts "**********************************************************"
puts prime_factor(23283064365386962890618) #5^32 - 7