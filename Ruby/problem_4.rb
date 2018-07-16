union = []
non_union = []
print "Do you want to pick the sets or not?"
choice = gets.chomp
if (choice == 1 || choice.downcase == 'y' || choice.downcase == "yes")
    print "Enter set without {}"
    set_1 = gets.chomp
    print "Enter another set without {}"
    set_2 = gets.chomp
else
    set_1 = [1,2,3,4,7]
    set_2 = [0,2,4,5,6]
end
set_1 =  set_1.include?(",")? set_1.split(",") : set_1.split(" ")
set_2 = set_2.include?(",")? set_2.split(",") : set_2.split(" ")

union = set_1 + set_2
union = union.uniq
non_union = set_1 & set_2
puts "The union is #{union}"
puts "The intersection is #{non_union}"