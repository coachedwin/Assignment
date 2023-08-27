

import React, { useState } from 'react';
import { View, TextInput, Button,Text,StyleSheet, } from 'react-native';
import { useDispatch } from 'react-redux';
import { addData } from './store';
import { useNavigation } from '@react-navigation/native';

const InputScreen = () => {
  const [name, setName] = useState('');
  const [plannedAmount, setPlannedAmount] = useState('');
  const [actualAmount, setActualAmount] = useState('');
  const dispatch = useDispatch();
  const navigation = useNavigation();

  const handleSave = () => {
    const data = {
      name,
      plannedAmount: parseFloat(plannedAmount),
      actualAmount: parseFloat(actualAmount),
    };
     dispatch({ type: 'ADD_DATA', payload: data });
    setName('');
    setPlannedAmount('');
    setActualAmount('');
  };

  const handleShowList = () => {
    navigation.navigate('List');
      };

  return (
    
    <View style={styles.container}>
        <Text style={styles.sectionTitle}>Enter your Budget Item here:</Text>

       <Text style={styles.sectionHeader}> Enter Item Name:</Text>
      <TextInput
        style={styles.input}
        value={name}
        onChangeText={setName}
        placeholder="Item Name"
      />

      <Text style={styles.sectionHeader}>Enter Planned Amount:</Text>
      <TextInput
        style={styles.input}
        value={plannedAmount}
        onChangeText={setPlannedAmount}
        placeholder="Planned Amount"
        keyboardType="numeric"
      />

      <Text style={styles.sectionHeader}>Enter Actual Amount:</Text>
      <TextInput
        style={styles.input}
        value={actualAmount}
        onChangeText={setActualAmount}
        placeholder="Actual Amount"
        keyboardType="numeric"
      />
  
      <Button title="Save" onPress={handleSave} />
      
      <Button title="Show List" onPress={handleShowList} />
      
      
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 20,
  },
  sectionTitle: {
    fontSize: 30,
    fontWeight: 'bold',
    marginBottom: 10,
  },
  sectionHeader :{
    fontSize: 20,
    marginBottom: 10,
   
  },
  input: {
    borderWidth: 1,
    borderColor: '#ccc',
    borderRadius: 5,
    padding: 10,
    marginBottom: 10,
    backgroundColor: '#fff'
  },
});

export default InputScreen;
