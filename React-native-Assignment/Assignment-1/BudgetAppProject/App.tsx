import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import { Provider } from 'react-redux';
import store from './src/store';
import InputScreen from './src/InputScreen';
import ListScreen from './src/ListScreen';

const Stack = createNativeStackNavigator();


const App = () => {
  return (
    <Provider store={store}>
      <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="Input" component={InputScreen} />
        <Stack.Screen name="List" component={ListScreen} />
      </Stack.Navigator>
      </NavigationContainer>
    </Provider>
  );
};

export default App;
