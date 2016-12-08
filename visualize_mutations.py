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
    try:
        P = subprocess.Popen([path_to_show_mutant_sh_scrpt, mutant_id], stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    except Exception as e:
        raise "Please put '#!/bin/sh' in your shell script"
    out, err = P.communicate()
    mutant_id_and_output[mutant_id] = {"status": status, "output": out.decode("utf-8")}


aggregated_mutant_output_file = open("aggregated_mutant_output.csv",'w')
csv_writer = csv.writer(aggregated_mutant_output_file, delimiter=',')
# Change the mutant_output_headers to include the 6 secitons of the output.split("\n")
        # join the output into ONE string via a pipe or some other unique character
mutant_output_headers = ["MutantID", "Status", "Output"]
csv_writer.writerow(mutant_output_headers)

mutant_id_and_output.pop('MutantNo', None)

counter = []
for mutant_id, result in mutant_id_and_output.items():
    status = result["status"]
    output = result["output"]
    output_list = output.split("\n")
    output_string = "|".join(output_list)
    csv_writer.writerow([mutant_id, status, output_string])
    print("For Mutant ID: " + mutant_id + ", Status: " + status + ", Output: ")
    print("")
    for string in output.split("\n"):
        print(string)
    print("")


# pdb.set_trace()
# "./mutation_results/killed.csv"
# "./show_mutant.sh"
