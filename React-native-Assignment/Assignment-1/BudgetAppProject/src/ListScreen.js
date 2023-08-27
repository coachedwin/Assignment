import React from 'react';
import { useSelector } from 'react-redux';
import { View, Text, FlatList, StyleSheet } from 'react-native';

const ListScreen = () => {
  const data = useSelector(state => state.data);

  const renderData = ({ item, index }) => (
    <View style={styles.row}>
      <Text style={styles.rowNumber}>{index + 1}</Text>
      <View style={styles.column}>
        <Text style={styles.columnHeader}>Name:</Text>
        <Text style={styles.columnData}>{item.name}</Text>
      </View>
      <View style={styles.column}>
        <Text style={styles.columnHeader}>Planned Amount:</Text>
        <Text style={styles.columnData}>{item.plannedAmount.toFixed(2)}</Text>
      </View>
      <View style={styles.column}>
        <Text style={styles.columnHeader}>Actual Amount:</Text>
        <Text style={styles.columnData}>{item.actualAmount.toFixed(2)}</Text>
      </View>
    </View>
  );

  return (
    <FlatList
      data={data}
      renderItem={renderData}
      keyExtractor={(item, index) => index.toString()}
      style={styles.list}
    />
  );
};

const styles = StyleSheet.create({
  list: {
    padding: 16,
  },
  row: {
    flexDirection: 'row',
    alignItems: 'center',
    borderBottomWidth: 1,
    borderBottomColor: '#ccc',
    paddingBottom: 8,
    marginBottom: 8,
  },
  rowNumber: {
    width: 30,
    marginRight: 8,
    fontSize: 16,
    fontWeight: 'bold',
  },
  column: {
    flex: 1,
    marginRight: 8,
  },
  columnHeader: {
    fontSize: 16,
    fontWeight: 'bold',
    marginBottom: 4,
  },
  columnData: {
    fontSize: 16,
  },
});

export default ListScreen;
