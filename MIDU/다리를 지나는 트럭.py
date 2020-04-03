from collections import namedtuple

def solution(bridge_length, weight, truck_weights):
    time = 0
    bridge = []
    bridge_weight = 0
    truck_weights.reverse()
    Truck = namedtuple("Truck", 'weight start_time')
    
    while truck_weights:
        time += 1
        if bridge and (bridge[0].start_time + bridge_length) <= time:
            bridge_weight -= bridge.pop(0).weight
        if truck_weights and bridge_weight + truck_weights[-1] <= weight:
            bridge_weight += truck_weights[-1]
            bridge.append(Truck(truck_weights.pop(), time))
        #print(bridge, time)
                      
    return time + bridge_length