import pdb
import csv
import subprocess

'''
Steps in this script

Terminal interaction for user:
1. Ask for path to killed csv
2. Ask for name of show_mutant scrip "show_mutation.sh"

After terminal questions:
1A. Loop through killed csv
1B. Run shell script from python using killed csv ID
1C. Save output in hash or some other object
1D. Run through hash/object and save data to another file
'''


'''
Get File Path for the Mutation CSV
* sample file path to killed.csv (if you are in the triangle example): "./mutation_results/killed.csv"
'''
path_to_killed_csv = input("Please enter path to Mutation Killed CSV: ")

'''
Get File Path for the Show Mutant <ID> Shell Script
* sample file path to show_mutant.sh (if you are in the triangle example): "./show_mutant.sh"
'''
path_to_show_mutant_sh_scrpt = input("Please enter path to Show Mutatnt Shell Script: ")


'''
Mutant ID and Status Dictionary
'''
mutant_id_status = {}


def read_csv(file_name, data_store):
    '''
    Open Killed.CSV and load data in here
    '''
    index_counter = 0
    with open(file_name) as csvfile:
        readCSV = csv.reader(csvfile, delimiter=',')
        for row in readCSV:
            mutant_id = row[0]
            mutant_status = row[1]
            data_store[mutant_id] = mutant_status

read_csv(path_to_killed_csv, mutant_id_status)

'''
1. Iterate through Mutant ID/Status Data Strcuture
2. Trigger show_mutant sh script
3. Save output in another data structure
'''

mutant_id_and_output = {}
for mutant_id, status in mutant_id_status.items():
    # Trying to figure out how to call ./show_mutant.sh 145 from inside python
    pdb.set_trace()
    P = subprocess.Popen([path_to_show_mutant_sh_scrpt, mutant_id])
    subprocess.call([path_to_show_mutant_sh_scrpt, mutant_id])

    p = subprocess.Popen([path_to_show_mutant_sh_scrpt, int(mutant_id)], stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    pdb.set_trace()
    out, err = p.communicate()

# ./mutation_results/killed.csv
# ./show_mutant.sh
